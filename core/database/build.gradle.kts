/*
 * Copyright 2022 microboat. All rights reserved.
 */

plugins {
    alias(libs.plugins.companion.android.library)
    alias(libs.plugins.companion.android.library.jacoco)
    alias(libs.plugins.companion.android.room)
    alias(libs.plugins.companion.hilt)
}

android {
    namespace = "com.microboat.companion.core.database"
}

dependencies {
    api(projects.core.model)

    implementation(libs.kotlinx.datetime)

    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.kotlinx.coroutines.test)
}
