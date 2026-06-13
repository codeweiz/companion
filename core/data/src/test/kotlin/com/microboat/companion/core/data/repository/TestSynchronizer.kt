/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.data.repository

import com.microboat.companion.core.data.Synchronizer
import com.microboat.companion.core.datastore.AppPreferencesDataSource
import com.microboat.companion.core.datastore.ChangeListVersions

/**
 * Test synchronizer that delegates to [AppPreferencesDataSource]
 */
class TestSynchronizer(
    private val niaPreferences: AppPreferencesDataSource,
) : Synchronizer {
    override suspend fun getChangeListVersions(): ChangeListVersions =
        niaPreferences.getChangeListVersions()

    override suspend fun updateChangeListVersions(
        update: ChangeListVersions.() -> ChangeListVersions,
    ) = niaPreferences.updateChangeListVersion(update)
}
