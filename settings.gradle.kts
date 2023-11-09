pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MIITest"
include(":app")
include(":core:model")
include(":core:designsystem")
include(":core:ui")
include(":core:common")
include(":core:network")
include(":logger")
include(":core:data")
include(":core:domains")
include(":core:test")
