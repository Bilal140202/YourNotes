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
            id = "yournote.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }


        register("androidApplication") {
            id = "yournote.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
       

        register("androidLibraryCompose") {
            id = "yournote.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "yournote.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "yournote.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidTest") {
            id = "yournote.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("androidHilt") {
            id = "yournote.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }


        register("androidLint") {
            id = "yournote.android.lint"
            implementationClass = "AndroidLintConventionPlugin"
        }

        register("jvmLibrary") {
            id = "yournote.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }

        register("androidRoom") {
            id = "yournote.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("kover") {
            id = "yournote.kover"
            implementationClass = "KoverConventionPlugin"
        }
    }
}
