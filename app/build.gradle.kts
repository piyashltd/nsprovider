plugins {
    id("com.android.application")
    kotlin("android")
    id("com.lagradost.cloudstream3.plugins")
}

cloudstream {
    repoName = "My JSON Extension"
    repoDescription = "Custom API based Cloudstream Extension"
    repoAuthor = "You"
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
    // এখানেও master-SNAPSHOT ব্যবহার করা হয়েছে
    implementation("com.github.recloudstream:cloudstream:master-SNAPSHOT")
}
