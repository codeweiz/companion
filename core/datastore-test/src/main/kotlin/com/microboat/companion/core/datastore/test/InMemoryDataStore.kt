/*
 * Copyright 2024 microboat. All rights reserved.
 */
package com.microboat.companion.core.datastore.test

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.updateAndGet

class InMemoryDataStore<T>(initialValue: T) : DataStore<T> {
    override val data = MutableStateFlow(initialValue)
    override suspend fun updateData(
        transform: suspend (it: T) -> T,
    ) = data.updateAndGet { transform(it) }
}
