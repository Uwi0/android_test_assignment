import org.gradle.internal.classpath.Instrumented

plugins {
    id("kakapo.android.library")
    id("kakapo.android.library.jacoco")
    id("kakapo.android.hilt")
    id("kakapo.android.room")
}


android {
    namespace = "com.kakapo.databases"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            all {
                Instrumented.systemProperty("mockk.androidTestRunnerSdk", "28")
            }
        }
    }
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    configurations.all {
        resolutionStrategy {
            // Exclude mockk-agent-jvm only for Android tests
            exclude(group = "io.mockk", module = "mockk-agent-jvm")
        }
    }
    packagingOptions {
        resources.excludes.add("META-INF/LICENSE.md")
        resources.excludes.add("META-INF/LICENSE-notice.md")
    }
}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

//    androidTestImplementation(project(":core:testing"))
}