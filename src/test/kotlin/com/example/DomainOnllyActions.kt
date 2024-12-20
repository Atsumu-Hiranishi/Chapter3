package com.example

import com.example.*
import com.example.pesticide.core.DdtProtocol
import com.example.pesticide.core.DomainOnly
import com.example.pesticide.core.Ready

class DomainOnlyActions : ZettaiActions {
    override val protocol: DdtProtocol = DomainOnly
    override fun prepare() = Ready

    private val store: ToDoListStore = mutableMapOf()
    private val fetcher = ToDoListFetcherFromMap(store)

    private val hub = ToDoListHub(fetcher)


    override fun getToDoList(user: User, listName: ListName): ToDoList? =
        hub.getList(user, listName)


    override fun addListItem(user: User, listName: ListName, item: ToDoItem) {
        hub.addItemToList(user, listName, item)
    }

    override fun ToDoListOwner.`starts with a list`(listName: String, items: List<String>) {
        val newList = ToDoList.build(listName, items)
        fetcher.assignListToUser(user, newList)
    }

}