plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

kotlin {
    android {
        namespace = "com.smgrealestate.core.domain"
        compileSdk = 34
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:data"))
    implementation(libs.koin.android)
    testImplementation(libs.junit)
}