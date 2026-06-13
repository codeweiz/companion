/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.data.util

import kotlinx.coroutines.flow.Flow

/**
 * Utility for reporting app connectivity status
 */
interface NetworkMonitor {
    val isOnline: Flow<Boolean>
}
