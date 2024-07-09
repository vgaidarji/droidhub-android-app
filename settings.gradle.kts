pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com.android.*")
                includeGroupByRegex("com.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "GitHub Android Application"

// register new modules in buildSrc/AppConfig for future references in build files
include(":app")
include(":base")
include(":feature:profile")
include(":feature:repositories")
include(":feature:contributions")
include(":core:api")
include(":core:repository")
include(":model")
