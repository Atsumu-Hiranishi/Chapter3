import org.gradle.api.JavaVersion.VERSION_11
import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    id("org.jetbrains.kotlin.jvm".toString())
}

kotlin {
    jvmToolchain(11)
}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    implementation("org.http4k:http4k-core:${http4kVersion}")
    implementation("org.http4k:http4k-server-jetty:${http4kVersion}")

    testImplementation("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:${junitLauncherVersion}")

    testImplementation("com.example.pesticide:pesticide-core:${pesticideVersion}")
    testImplementation("io.strikt:strikt-core:${striktVersion}")
    testImplementation("org.http4k:http4k-client-jetty:${http4kVersion}")
    testImplementation("org.jsoup:jsoup:${jsoupVersion}")
}

tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events "passed", "skipped", "failed"
        }

        //if true show println in test console
        testLogging.showStandardStreams = false

        // start tests every time, even when code not changed
        outputs.upToDateWhen { false }

    }
}


}