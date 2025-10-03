plugins {
    alias(libs.plugins.android.test)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.benchmark"
    compileSdk = 36

    defaultConfig {
        minSdk = 23
        targetSdk = 36

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        // Benchmark buildType = شبه الـ Release لكن موقّع بـ debug key
        create("benchmark") {
            isDebuggable = true
            signingConfig = getByName("debug").signingConfig
            matchingFallbacks += listOf("release")
        }
    }

    // ده بيربط benchmark مع الـ app target
    targetProjectPath = ":app"
    experimentalProperties["android.experimental.self-instrumenting"] = true
}

// --- JVM / Kotlin config ---
kotlin {
    jvmToolchain(11) // خلي Toolchain على Java 17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "11" // لازم String
    }
}

tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = "11" // خليهم String مش JavaVersion
    targetCompatibility = "11"
}

// --- Dependencies ---
dependencies {
    implementation(libs.androidx.junit)
    implementation(libs.androidx.espresso.core)
    implementation(libs.androidx.uiautomator)
    implementation(libs.androidx.benchmark.macro.junit4)
}

// --- Enable benchmark buildType only ---
androidComponents {
    beforeVariants(selector().all()) {
        it.enable = it.buildType == "benchmark"
    }
}
