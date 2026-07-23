pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.lagradost.cloudstream3.plugins")) {
                // এখানে master-SNAPSHOT দেওয়া হয়েছে ব্রোকেন ক্যাশ বাইপাস করার জন্য
                useModule("com.github.recloudstream:gradle:master-SNAPSHOT")
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

include(":app")
