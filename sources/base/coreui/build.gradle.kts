plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Config.Android.compileSdkVersion)
    defaultConfig {
        minSdkVersion(Config.Android.minSdkVersion)
        targetSdkVersion(Config.Android.targetSdkVersion)
        versionCode = Config.Android.versionCode
        versionName = Config.Android.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/kotlin")
        }
    }
}

dependencies {
    implementation(project(":presentation"))

    implementation(Config.Libs.appCompat)
    implementation(Config.Libs.cardView)
    implementation(Config.Libs.constraintLayout)
    implementation(Config.Libs.design)

    implementation(Config.Libs.cicerone)

    implementation(Config.Libs.koin)
    implementation(Config.Libs.koinAndroid)
    implementation(Config.Libs.koinAndroidViewModel)

    implementation(Config.Libs.kotlin)
    implementation(Config.Libs.kotlinCoroutines)

    implementation(Config.Libs.timber)

    implementation(Config.Libs.retrofit)
    implementation(Config.Libs.retrofitGson)
}
