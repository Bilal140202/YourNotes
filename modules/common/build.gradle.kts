/*
 *abiola 2024
 */
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.yournote.android.library")
    id("com.yournote.android.hilt")
}

android {
    namespace = "com.yournote.common"
}

dependencies {
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
    implementation(libs.kotlinx.datetime)
    googlePlayImplementation(libs.play.services.mlkit.text.recognition)


}