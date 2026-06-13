/*
 * Copyright 2022 microboat. All rights reserved.
 */

plugins {
    alias(libs.plugins.companion.android.feature.impl)
    alias(libs.plugins.companion.android.library.compose)
    alias(libs.plugins.companion.android.library.jacoco)
}

android {
    namespace = "com.microboat.companion.feature.topic.impl"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.feature.topic.api)

    implementation(libs.androidx.compose.material3.adaptive.navigation3)

    testImplementation(projects.core.testing)
    testImplementation(libs.robolectric)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
    androidTestImplementation(projects.core.testing)
}
