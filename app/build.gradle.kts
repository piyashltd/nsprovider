plugins {
    id("com.android.application")
    kotlin("android") // id("kotlin-android") এর পরিবর্তে এটি ব্যবহার করা ভালো
}

// রুট ফাইলের buildscript থেকে প্লাগিনটি অ্যাপ্লাই করার জন্য
apply(plugin = "com.lagradost.cloudstream3.plugins")

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
