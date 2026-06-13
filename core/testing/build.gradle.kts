/*
 * Copyright 2022 microboat. All rights reserved.
 */
plugins {
    alias(libs.plugins.companion.android.library)
    alias(libs.plugins.companion.hilt)
}

android {
    namespace = "com.microboat.companion.core.testing"
}

dependencies {
    api(libs.kotlinx.coroutines.test)
    api(projects.core.analytics)
    api(projects.core.common)
    api(projects.core.data)
    api(projects.core.model)
    api(projects.core.notifications)


    implementation(libs.androidx.test.rules)
    implementation(libs.hilt.android.testing)
    implementation(libs.kotlinx.datetime)
}
