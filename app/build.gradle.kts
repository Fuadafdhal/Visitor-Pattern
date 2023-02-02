plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
}

private val majorVersion = 1
private val minorVersion = 0
private val patchVersion = 1
private val preRelease = ""
private val release = ""

android {
    namespace = "com.afdhal_fa.visitorpattern"
    compileSdk = 32

    defaultConfig {
        applicationId = "com.afdhal_fa.visitorpattern"
        minSdk = 23
        targetSdk = 32
        versionCode = generateVersionCode()
        versionName = generateVersionName()
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        setProperty("archivesBaseName", "Visitor Patter-$versionName")
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            isDebuggable = true
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }


    applicationVariants.all {
        val variant = this
        variant.outputs.map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
            .forEach { output ->
                val outputFileName = "Visitor Pattern-${variant.baseName}-${variant.versionName}.apk"
                output.outputFileName = outputFileName
            }
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

fun generateVersionCode(): Int {
    return majorVersion * 10000 + minorVersion * 100 + patchVersion
}

fun generateVersionName(): String {
    var versionName = "$majorVersion.$minorVersion.$patchVersion"
    if (preRelease.isNotEmpty()) {
        versionName = "$versionName-$preRelease"
    }
    return versionName
}

dependencies {
    //Default Android
    implementation("com.google.android.material:material:1.6.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")

    //UI
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.2")

    //Test
    implementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.aar", "*.jar"))))
}