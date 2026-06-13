/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.datastore.test

import androidx.datastore.core.DataStore
import com.microboat.companion.core.datastore.UserPreferences
import com.microboat.companion.core.datastore.UserPreferencesSerializer
import com.microboat.companion.core.datastore.di.DataStoreModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataStoreModule::class],
)
internal object TestDataStoreModule {
    @Provides
    @Singleton
    fun providesUserPreferencesDataStore(
        serializer: UserPreferencesSerializer,
    ): DataStore<UserPreferences> = InMemoryDataStore(serializer.defaultValue)
}
