/*
 * Copyright 2022 microboat. All rights reserved.
 */
plugins {
    alias(libs.plugins.companion.android.library)
    alias(libs.plugins.companion.hilt)
}

android {
    namespace = "com.microboat.companion.core.sync.test"
}

dependencies {
    implementation(libs.hilt.android.testing)
    implementation(projects.core.data)
    implementation(projects.sync.work)
}
