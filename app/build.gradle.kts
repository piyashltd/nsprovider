plugins {
    id("com.android.application")
    kotlin("android")
}

apply(plugin = "com.lagradost.cloudstream3.plugins")

// ঠিক এই লাইনটিতে পরিবর্তন করা হয়েছে
extensions.getByName("cloudstream").withGroovyBuilder {
    setProperty("repoName", "My JSON Extension")
    setProperty("repoDescription", "Custom API based Cloudstream Extension")
    setProperty("repoAuthor", "You")
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
