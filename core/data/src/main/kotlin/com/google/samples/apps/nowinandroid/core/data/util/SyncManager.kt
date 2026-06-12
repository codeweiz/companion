/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.google.samples.apps.nowinandroid.core.data.util

import kotlinx.coroutines.flow.Flow

/**
 * Reports on if synchronization is in progress
 */
interface SyncManager {
    val isSyncing: Flow<Boolean>
    fun requestSync()
}
