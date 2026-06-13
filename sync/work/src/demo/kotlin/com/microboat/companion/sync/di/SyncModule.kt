/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.sync.di

import com.microboat.companion.core.data.util.SyncManager
import com.microboat.companion.sync.status.StubSyncSubscriber
import com.microboat.companion.sync.status.SyncSubscriber
import com.microboat.companion.sync.status.WorkManagerSyncManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SyncModule {
    @Binds
    internal abstract fun bindsSyncStatusMonitor(
        syncStatusMonitor: WorkManagerSyncManager,
    ): SyncManager

    @Binds
    internal abstract fun bindsSyncSubscriber(
        syncSubscriber: StubSyncSubscriber,
    ): SyncSubscriber
}
