/*
 *abiola 2024
 */
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("yournote.android.library")

    id("yournote.android.hilt")
    id("yournote.android.room")
}

android {
    namespace = "com.yournote.database"


}

android {
    defaultConfig {
        testInstrumentationRunner = "com.yournote.testing.TestRunner"

    }
    namespace = "com.yournote.database"


}

dependencies {
    implementation(project(":modules:model"))
    implementation(libs.kotlinx.datetime)

    androidTestImplementation(project(":modules:testing"))

}