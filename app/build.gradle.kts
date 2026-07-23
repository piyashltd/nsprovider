plugins {
    id("com.android.application")
    kotlin("android")
}

// এই লাইনের মাধ্যমে রুট ফাইল থেকে প্লাগিনটি অ্যাপ্লাই হবে
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
