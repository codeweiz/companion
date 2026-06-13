/*
 * Copyright 2022 microboat. All rights reserved.
 */
plugins {
    alias(libs.plugins.companion.android.library)
    alias(libs.plugins.companion.android.library.compose)
    alias(libs.plugins.companion.hilt)
}

android {
    namespace = "com.microboat.companion.core.screenshottesting"
}

dependencies {
    api(libs.bundles.androidx.compose.ui.test)
    api(libs.roborazzi)
    api(libs.roborazzi.accessibility.check)
    implementation(libs.androidx.compose.ui.test)
    implementation(libs.androidx.activity.compose)
    implementation(libs.robolectric)
    implementation(projects.core.designsystem)
}
