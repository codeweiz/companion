/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.google.samples.apps.nowinandroid

/**
 * Shared build type definitions used by the app build.
 */
enum class NiaBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
}
