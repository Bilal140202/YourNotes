plugins {
    `kotlin-dsl`
}

group = "com.yournote.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    compileOnly(libs.firebase.performance.gradlePlugin)
    implementation(libs.truth)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
    compileOnly(libs.kotlin.powerAssert)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.kover.gradlePlugin)


}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {

        register("androidApplicationCompose") {
            id = "com.yournote.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplicationFlavor") {
            id = "com.yournote.android.application.flavor"
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }
        register("androidApplicationFirebase") {
            id = "com.yournote.android.application.firebase"
            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
        }

        register("androidApplication") {
            id = "com.yournote.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
       

        register("androidLibraryCompose") {
            id = "com.yournote.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.yournote.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "com.yournote.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidTest") {
            id = "com.yournote.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("androidHilt") {
            id = "com.yournote.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }


        register("androidLint") {
            id = "com.yournote.android.lint"
            implementationClass = "AndroidLintConventionPlugin"
        }

        register("jvmLibrary") {
            id = "com.yournote.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }

        register("androidRoom") {
            id = "com.yournote.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("kover") {
            id = "com.yournote.kover"
            implementationClass = "KoverConventionPlugin"
        }
    }
}
