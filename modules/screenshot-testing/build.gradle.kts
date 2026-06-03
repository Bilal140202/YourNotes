/*
 *abiola 2022
 */
plugins {
    id("com.yournote.android.library")
    id("com.yournote.android.library.compose")
    id("com.yournote.android.hilt")
}

android {
    namespace = "com.yournote.screenshottesting"
}

dependencies {
    implementation(libs.androidx.compose.ui.test)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui.test)
    implementation(projects.modules.common)
    implementation(projects.modules.designsystem)
}
