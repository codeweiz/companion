/*
 * Copyright 2023 microboat. All rights reserved.
 */
plugins {
    alias(libs.plugins.companion.android.library)
    alias(libs.plugins.companion.android.library.compose)
    alias(libs.plugins.companion.hilt)
}

android {
    namespace = "com.microboat.companion.core.analytics"
}

dependencies {
    implementation(libs.androidx.compose.runtime)

    prodImplementation(platform(libs.firebase.bom))
    prodImplementation(libs.firebase.analytics)
}
