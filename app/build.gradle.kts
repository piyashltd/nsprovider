plugins {
    id("com.android.application")
    kotlin("android")
}

// প্লাগিনটি সফলভাবে অ্যাপ্লাই হলো
apply(plugin = "com.lagradost.cloudstream3.plugins")

// Kotlin DSL-এর Type-Safe এরর বাইপাস করার জন্য Groovy Builder ব্যবহার
extensions.configure("cloudstream") {
    withGroovyBuilder {
        setProperty("repoName", "My JSON Extension")
        setProperty("repoDescription", "Custom API based Cloudstream Extension")
        setProperty("repoAuthor", "You")
    }
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 33
    
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
}

dependencies {
    implementation("com.github.recloudstream:cloudstream:master-SNAPSHOT")
}
