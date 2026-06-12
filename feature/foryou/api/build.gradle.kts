/*
 * Copyright 2022 microboat. All rights reserved.
 */

plugins {
    alias(libs.plugins.nowinandroid.android.feature.api)
}

android {
    namespace = "com.google.samples.apps.nowinandroid.feature.foryou.api"
}

dependencies {
    api(projects.core.navigation)
}
