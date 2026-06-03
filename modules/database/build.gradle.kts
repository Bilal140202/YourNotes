/*
 *abiola 2024
 */
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.yournote.android.library")

    id("com.yournote.android.hilt")
    id("com.yournote.android.room")
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