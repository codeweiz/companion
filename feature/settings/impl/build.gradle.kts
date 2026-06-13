/*
 * Copyright 2022 microboat. All rights reserved.
 */

plugins {
    alias(libs.plugins.companion.android.feature.impl)
    alias(libs.plugins.companion.android.library.compose)
    alias(libs.plugins.companion.android.library.jacoco)
}

android {
    namespace = "com.microboat.companion.feature.settings.impl"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.google.oss.licenses)
    implementation(projects.core.data)

    testImplementation(projects.core.testing)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
}
