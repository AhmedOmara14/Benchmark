plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.test) apply false
    alias(libs.plugins.benchmark) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.23" apply false
    id("com.google.dagger.hilt.android") version "2.52" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
