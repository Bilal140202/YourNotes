plugins {
    id("yournote.android.feature")
}

android {
    namespace = "com.yournote.gallery"
}

dependencies {
    implementation(libs.telephoto.zoomable.image)
    testImplementation(libs.hilt.android.testing)
    testImplementation(projects.modules.testing)
    implementation(libs.kotlinx.datetime)


    androidTestImplementation(projects.modules.testing)

}