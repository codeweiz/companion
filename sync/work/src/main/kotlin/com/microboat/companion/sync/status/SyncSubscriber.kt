/*
 * Copyright 2023 microboat. All rights reserved.
 */
package com.microboat.companion.sync.status

/**
 * Subscribes to backend requested synchronization
 */
interface SyncSubscriber {
    suspend fun subscribe()
}
