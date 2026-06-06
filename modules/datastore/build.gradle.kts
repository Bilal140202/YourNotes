/*
 *abiola 2024
 */

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("yournote.android.library")
    id("yournote.android.hilt")
    alias(libs.plugins.kotlin.serialization)

}

android {
    defaultConfig {
        consumerProguardFiles("consumer-proguard-rules.pro")
    }
    namespace = "com.yournote.datastore"
}
dependencies {
    implementation(libs.kotlinx.serialization.json)
    api(libs.androidx.dataStore.core)
    api(libs.androidx.datastore.core.okio)
    api(
        project(":modules:model")
    )
    api(
        project(":modules:common")
    )

    testImplementation(libs.kotlinx.coroutines.test)
    implementation(libs.hilt.android.testing)


}
