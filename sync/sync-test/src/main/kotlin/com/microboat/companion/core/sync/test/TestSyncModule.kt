/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.sync.test

import com.microboat.companion.core.data.util.SyncManager
import com.microboat.companion.sync.di.SyncModule
import com.microboat.companion.sync.status.StubSyncSubscriber
import com.microboat.companion.sync.status.SyncSubscriber
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [SyncModule::class],
)
internal interface TestSyncModule {
    @Binds
    fun bindsSyncStatusMonitor(
        syncStatusMonitor: NeverSyncingSyncManager,
    ): SyncManager

    @Binds
    fun bindsSyncSubscriber(
        syncSubscriber: StubSyncSubscriber,
    ): SyncSubscriber
}
