/*
 * Copyright 2022 microboat. All rights reserved.
 */
plugins {
    alias(libs.plugins.companion.jvm.library)
    alias(libs.plugins.companion.hilt)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
}
