plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.lagradost.cloudstream3.plugins") version "1.0.4" // এই অংশটুকু যোগ করতে হবে
}

cloudstream {
    setRepoName("My JSON Extension")
    setRepoDescription("Custom API based Cloudstream Extension")
    setRepoAuthor("You")
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
    implementation("com.github.recloudstream:cloudstream:-SNAPSHOT")
}
