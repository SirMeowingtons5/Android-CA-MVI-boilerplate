object Config {
    object Versions {
        const val kotlin = "1.3.11"
        const val kotlinCoroutines = "1.1.0"
        const val androidGradle = "3.3.0"
        const val supportLibrary = "27.1.1"
        const val lifecycle = "1.1.1"
        const val constraintLayout = "1.1.0"

        const val anko = "0.10.8"

        const val koin = "1.0.2"

        const val cicerone = "4.0.2"

        const val timber = "4.7.1"

        const val retrofit = "2.5.0"

        const val glide = "4.8.0"

        const val jUnit = "4.12"
        const val espressoCore = "3.0.2"
        const val testRunner = "1.0.2"
    }

    object BuildPlugins {
        const val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradle}"
        const val googleServices = "com.google.gms:google-services:4.0.1"
    }

    object Android {
        const val buildToolsVersion = "28.0.3"
        const val minSdkVersion = 21
        const val targetSdkVersion = 28
        const val compileSdkVersion = 28
        const val applicationId = "my.company.app"
        const val versionCode = 1
        const val versionName = "0.0.1-prealpha"
    }

    object Libs {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
        const val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"

        const val appCompat = "com.android.support:appcompat-v7:${Versions.supportLibrary}"
        const val design = "com.android.support:design:${Versions.supportLibrary}"
        const val supportAnnotations = "com.android.support:support-annotations:${Versions.supportLibrary}"
        const val cardView = "com.android.support:cardview-v7:${Versions.supportLibrary}"

        const val anko = "org.jetbrains.anko:anko:${Versions.anko}"

        const val cicerone = "ru.terrakok.cicerone:cicerone:${Versions.cicerone}"

        const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

        const val lifecycle = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
        const val lifecycleCompiler = "android.arch.lifecycle:compiler:${Versions.lifecycle}"

        const val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"

        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glideAnnotationProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"

        //koin
        val koin = koin("core")
        val koinExt = koin("core-ext")
        val koinTest = koin("test")
        val koinAndroid = koin("android")
        val koinAndroidScope = koin("android-scope")
        val koinAndroidViewModel = koin("android-viewmodel")
    }

    object TestLibs {
        const val jUnit = "junit:junit:${Versions.jUnit}"
        const val testRunner = "com.android.support.test:runner:${Versions.testRunner}"
        const val espressoCore = "com.android.support.test.espresso:espresso-core:${Versions.espressoCore}"
    }
}

fun koin(module: String, version: String = Config.Versions.koin) = "org.koin:koin-$module:$version"