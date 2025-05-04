plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

kotlin {
    android {
        namespace = "com.smgrealestate.core.data"
        compileSdk = 34
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {

    implementation(project(":core:model"))
    implementation(project(":core:network"))
    implementation(project(":core:storage"))
    implementation(libs.koin.android)
    testImplementation(libs.junit)
}