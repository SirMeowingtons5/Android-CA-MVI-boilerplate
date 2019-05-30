plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
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
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            consumerProguardFiles("proguard-rules.pro")
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

    implementation(Config.Libs.anko)

    implementation(Config.Libs.cicerone)

    implementation(Config.Libs.timber)

    implementation(Config.Libs.glide)
    kapt(Config.Libs.glideAnnotationProcessor)

    implementation(Config.Libs.lifecycle)
    implementation(Config.Libs.kotlin)
    implementation(Config.Libs.kotlinCoroutines)
    implementation(Config.Libs.kotlinCoroutinesAndroid)

    implementation(Config.Libs.koinTest)
    implementation(Config.Libs.koinAndroid)
}