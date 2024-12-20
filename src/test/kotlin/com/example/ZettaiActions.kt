package com.example

import com.example.ListName
import com.example.ToDoItem
import com.example.ToDoList
import com.example.User
import com.example.pesticide.core.DdtActions
import com.example.pesticide.core.DdtProtocol
import com.example.pesticide.core.DomainDrivenTest


interface ZettaiActions : DdtActions<DdtProtocol> {
    fun ToDoListOwner.`starts with a list`(listName: String, items: List<String>)

    fun getToDoList(user: User, listName: ListName): ToDoList?
    fun addListItem(user: User, listName: ListName, item: ToDoItem)
}

typealias ZettaiDDT = DomainDrivenTest<ZettaiActions>

fun allActions() = setOf(
    DomainOnlyActions(),
    HttpActions()
)