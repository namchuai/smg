plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

kotlin {
    android {
        namespace = "com.smgrealestate.core.model"
        compileSdk = 34
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}
