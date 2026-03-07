pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "MyNowInAndroid"

/**
 * 这句话的作用是
 * : 会变成层级访问
 * :feature:foryou:api → projects.feature.foryou.api
 * - 会转成驼峰
 * :core:data-test → projects.core.dataTest
 */
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":core:model")
include(":core:data")
include(":core:database")
include(":core:common")
include(":core:datastore")
include(":core:datastore-proto")
