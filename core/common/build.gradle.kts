plugins {
    id("kakapo.android.library")
    id("kakapo.android.library.jacoco")
    id("kakapo.android.hilt")
}

android {
    namespace = "com.kakapo.common"
}

dependencies {
    api(project(":logger"))
    implementation(platform(libs.arrow.bom))
    api(libs.arrow.core)
    api(libs.arrow.fx.coroutines)
    implementation(libs.kotlinx.coroutines.android)
}