/*
 * Copyright 2022 microboat. All rights reserved.
 */

plugins {
    alias(libs.plugins.companion.android.feature.api)
    alias(libs.plugins.companion.android.feature.impl)
    alias(libs.plugins.companion.android.library.compose)
}

android {
    namespace = "com.microboat.companion.feature.topic.api"
}
