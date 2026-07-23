plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.lagradost.cloudstream3.plugins") // এখান থেকে version "1.0.0" অংশটি বাদ দেওয়া হয়েছে
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
