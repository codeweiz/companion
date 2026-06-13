/*
 * Copyright 2022 microboat. All rights reserved.
 */

plugins {
    alias(libs.plugins.companion.android.feature.api)
}

android {
    namespace = "com.microboat.companion.feature.foryou.api"
}

dependencies {
    api(projects.core.navigation)
}
