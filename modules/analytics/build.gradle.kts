/*
 *abiola 2024
 */
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.yournote.android.library")
    id("com.yournote.android.library.compose")

    id("com.yournote.android.hilt")
}

android {
    namespace = "com.yournote.analytics"
}

dependencies {
    implementation(libs.androidx.compose.runtime)

    //  prodImplementation(platform(libs.firebase.bom))
    googlePlayImplementation(platform(libs.firebase.bom))

    googlePlayImplementation(libs.firebase.analytics)
}
