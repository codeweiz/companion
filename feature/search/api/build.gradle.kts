/*
 * Copyright 2023 microboat. All rights reserved.
 */

plugins {
    alias(libs.plugins.companion.android.feature.api)
}

android {
    namespace = "com.microboat.companion.feature.search.api"
}

dependencies {
    implementation(projects.core.domain)
}
