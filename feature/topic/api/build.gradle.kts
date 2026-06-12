/*
 * Copyright 2022 microboat. All rights reserved.
 */

plugins {
    alias(libs.plugins.nowinandroid.android.feature.api)
    alias(libs.plugins.nowinandroid.android.feature.impl)
    alias(libs.plugins.nowinandroid.android.library.compose)
}

android {
    namespace = "com.google.samples.apps.nowinandroid.feature.topic.api"
}
