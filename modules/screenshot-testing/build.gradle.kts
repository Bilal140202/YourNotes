/*
 *abiola 2022
 */
plugins {
    id("yournote.android.library")
    id("yournote.android.library.compose")
    id("yournote.android.hilt")
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
