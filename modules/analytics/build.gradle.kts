/*
 *abiola 2024
 */
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("yournote.android.library")
    id("yournote.android.library.compose")

    id("yournote.android.hilt")
}

android {
    namespace = "com.yournote.analytics"
}

dependencies {
    implementation(libs.androidx.compose.runtime)
}
