plugins {
    id("kakapo.android.library")
}

android {
    namespace = "id.co.jarvis.logger"
}

dependencies{
    implementation(libs.timber.logging)
}
