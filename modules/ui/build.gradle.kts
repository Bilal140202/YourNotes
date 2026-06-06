/*
 *abiola 2024
 */
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("yournote.android.library")
    id("yournote.android.library.compose")

}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.yournote.ui"
}

dependencies {
    api(libs.androidx.metrics)
    api(project(":modules:analytics"))
    api(project(":modules:designsystem"))
    api(project(":modules:model"))

    implementation(libs.androidx.browser)
    implementation(libs.coil.kt)
    api(libs.coil.kt.compose)
    implementation(libs.kotlinx.datetime)

    implementation(libs.androidx.activity.compose)


    androidTestImplementation(project(":modules:testing"))
}
