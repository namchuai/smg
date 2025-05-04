plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    android {
        namespace = "com.smgrealestate.core.network"
        compileSdk = 34
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.ktor.common)
    implementation(libs.androidx.core.ktx)
    implementation(libs.koin.android)
    testImplementation(libs.junit)
}
