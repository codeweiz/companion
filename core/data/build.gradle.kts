/*
 * Copyright 2022 microboat. All rights reserved.
 */
plugins {
    alias(libs.plugins.companion.android.library)
    alias(libs.plugins.companion.android.library.jacoco)
    alias(libs.plugins.companion.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.microboat.companion.core.data"
    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    api(projects.core.common)
    api(projects.core.database)
    api(projects.core.datastore)
    api(projects.core.network)

    implementation(projects.core.analytics)
    implementation(projects.core.notifications)

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlinx.serialization.json)
    testImplementation(projects.core.datastoreTest)
    testImplementation(projects.core.testing)
}
