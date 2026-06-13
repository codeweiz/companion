/*
 * Copyright 2022 microboat. All rights reserved.
 */
plugins {
    alias(libs.plugins.companion.android.library)
    alias(libs.plugins.companion.android.library.jacoco)
    alias(libs.plugins.companion.hilt)
}

android {
    defaultConfig {
        testInstrumentationRunner = "com.microboat.companion.core.testing.AppTestRunner"
    }
    namespace = "com.microboat.companion.sync"
}

dependencies {
    ksp(libs.hilt.ext.compiler)

    implementation(libs.androidx.tracing.ktx)
    implementation(libs.androidx.work.ktx)
    implementation(libs.hilt.ext.work)
    implementation(projects.core.analytics)
    implementation(projects.core.data)
    implementation(projects.core.notifications)

    prodImplementation(libs.firebase.cloud.messaging)
    prodImplementation(platform(libs.firebase.bom))

    androidTestImplementation(libs.androidx.work.testing)
    androidTestImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.kotlinx.coroutines.guava)
    androidTestImplementation(projects.core.testing)
}
