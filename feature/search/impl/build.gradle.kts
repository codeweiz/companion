/*
 * Copyright 2023 microboat. All rights reserved.
 */

plugins {
    alias(libs.plugins.companion.android.feature.impl)
    alias(libs.plugins.companion.android.library.compose)
    alias(libs.plugins.companion.android.library.jacoco)
}

android {
    namespace = "com.microboat.companion.feature.search.impl"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.feature.interests.api)
    implementation(projects.feature.search.api)
    implementation(projects.feature.topic.api)

    testImplementation(projects.core.testing)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
    androidTestImplementation(projects.core.testing)
}
