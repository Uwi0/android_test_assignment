plugins {
    id("kakapo.android.library")
    id("kakapo.android.library.jacoco")
    kotlin("kapt")
}
android {
    namespace = "com.kakapo.domains"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:data"))
    implementation(project(":core:common"))

    implementation(libs.google.play.service.code.scanner)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}