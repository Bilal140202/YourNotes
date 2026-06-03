import com.yournote.app.BuildType


@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
//    alias(libs.plugins.kotlinAndroid)


    id("yournote.android.application")
    id("yournote.android.application.compose")
    id("yournote.android.hilt")

}

android {
    namespace = "com.yournote.notepad"

    signingConfigs {
        create("release") {
            storeFile = file("../yournotes-release.jks")
            storePassword = "yournotes2025"
            keyAlias = "yournotes"
            keyPassword = "yournotes2025"
        }
    }

    defaultConfig {
        applicationId = "com.yournote.notepad"
        versionCode = libs.versions.versionCode.get().toIntOrNull()
        versionName = System.getenv("VERSION_NAME") ?: libs.versions.versionName.get()

        testInstrumentationRunner = "com.yournote.testing.TestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = BuildType.DEBUG.applicationIdSuffix
            versionNameSuffix=BuildType.DEBUG.versionNameSuffix

        }
        val release = getByName("release") {
            isMinifyEnabled = true
            applicationIdSuffix = BuildType.RELEASE.applicationIdSuffix
            versionNameSuffix=BuildType.RELEASE.versionNameSuffix

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }

    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(projects.modules.designsystem)
    implementation(projects.modules.data)
    implementation(projects.modules.ui)
    implementation(projects.modules.domain)


    implementation(projects.feature.main)
    implementation(projects.feature.detail)
    implementation(projects.feature.gallery)
    implementation(projects.feature.drawing)
    implementation(projects.feature.about)
    implementation(projects.feature.label)
    implementation(projects.feature.selectlabel)
    implementation(projects.feature.setting)
    implementation(projects.feature.search)





    implementation(libs.kotlinx.serialization.json)


    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.lifecycle.viewmodel.navigation3)
//    implementation(libs.androidx.material3.adaptive.navigation3)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.androidx.tracing.ktx)
    implementation(libs.androidx.window.core)
    implementation(libs.kotlinx.coroutines.guava)
    implementation(libs.coil.kt)
    implementation(libs.timber)

    ksp(libs.hilt.compiler)

    debugImplementation(libs.androidx.compose.ui.testManifest)
    debugImplementation(projects.uiTestHiltManifest)

    kspTest(libs.hilt.compiler)

    testImplementation(projects.modules.testing)
    testImplementation(libs.androidx.compose.ui.test)
    testImplementation(libs.androidx.work.testing)
    testImplementation(libs.hilt.android.testing)



    androidTestImplementation(projects.modules.testing)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test)
    androidTestImplementation(libs.hilt.android.testing)
    debugImplementation (libs.androidx.monitor)

    implementation(libs.play.review)
    implementation(libs.play.review.kts)
}

