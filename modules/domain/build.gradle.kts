/*
 *abiola 2024
 */
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("yournote.android.library")
    id("yournote.android.hilt")
}

android {
    namespace = "com.yournote.domain"
}
dependencies {
    api(projects.modules.data)
    api(projects.modules.model)


    testImplementation(projects.modules.testing)
}