plugins {
    alias(libs.plugins.android.application)
}

// citeste cheile din fisierul .env (din folderul modulului); fisierul nu intra in git
val env = mutableMapOf<String, String>()
val envFile = file(".env")
if (envFile.exists()) {
    envFile.readLines()
        .filter { it.isNotBlank() && !it.trimStart().startsWith("#") && it.contains("=") }
        .forEach {
            val parts = it.split("=", limit = 2)
            env[parts[0].trim()] = parts[1].trim()
        }
}

android {
    namespace = "com.example.laborato_9"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.laborato_9"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // ajunge in codul Java ca BuildConfig.ACCUWEATHER_API_KEY
        buildConfigField("String", "ACCUWEATHER_API_KEY", "\"${env["ACCUWEATHER_API_KEY"] ?: ""}\"")
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.activity.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
}