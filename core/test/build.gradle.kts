plugins {
    id("kakapo.android.library")
    id("kakapo.android.library.compose")
    id("kakapo.android.hilt")
}
android {
    namespace = "com.kakapo.test"
}

dependencies {

    implementation(libs.kotlinx.datetime)

    api(libs.junit4)
    api(libs.androidx.test.core)
    api(libs.kotlinx.coroutines.test)
    api(libs.turbine)

    api(libs.androidx.core.testing)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.runner)
    api(libs.androidx.test.rules)
    api(libs.androidx.compose.ui.test)
    api(libs.hilt.android.testing)
    api(libs.mockito.core)
    api(libs.mockito.kotlin)
    api(libs.mockk)
    api(libs.mockk.android)
    api(libs.robolectric.test)
    debugApi(libs.androidx.compose.ui.testManifest)
}