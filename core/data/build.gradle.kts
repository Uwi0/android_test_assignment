plugins {
    id("kakapo.android.library")
    id("kakapo.android.library.jacoco")
    id("kakapo.android.hilt")
    id("kotlinx-serialization")
}
android {
    namespace = "com.kakapo.data"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":core:network"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}