/*
 * Copyright 2023 microboat. All rights reserved.
 */
plugins {
    alias(libs.plugins.companion.android.library)
    alias(libs.plugins.companion.hilt)
}

android {
    namespace = "com.microboat.companion.core.notifications"
}

dependencies {
    api(projects.core.model)

    implementation(projects.core.common)

    compileOnly(platform(libs.androidx.compose.bom))
}
