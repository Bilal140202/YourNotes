plugins {
    id("yournote.android.feature")
}

android {
    namespace = "com.yournote.selectlabel"
}

dependencies {
    testImplementation(libs.hilt.android.testing)
    testImplementation(projects.modules.testing)
    implementation(libs.kotlinx.datetime)


    androidTestImplementation(projects.modules.testing)

}