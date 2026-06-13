/*
 * Copyright 2022 microboat. All rights reserved.
 */

plugins {
    alias(libs.plugins.companion.android.feature.impl)
    alias(libs.plugins.companion.android.library.compose)
}

android {
    namespace = "com.microboat.companion.feature.bookmarks.impl"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.feature.bookmarks.api)
    implementation(projects.feature.topic.api)

    testImplementation(projects.core.testing)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
    androidTestImplementation(projects.core.testing)
}
