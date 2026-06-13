/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion

/**
 * Shared build type definitions used by the app build.
 */
enum class AppBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
}
