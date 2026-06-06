plugins {
    id("yournote.android.feature")
}

android {
    namespace = "com.yournote.setting"
}

dependencies {
    implementation(libs.kotlinx.datetime)
    implementation(libs.lottie.compose)

}