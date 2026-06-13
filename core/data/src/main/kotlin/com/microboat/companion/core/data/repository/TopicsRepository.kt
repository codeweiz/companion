/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.data.repository

import com.microboat.companion.core.data.Syncable
import com.microboat.companion.core.model.data.Topic
import kotlinx.coroutines.flow.Flow

interface TopicsRepository : Syncable {
    /**
     * Gets the available topics as a stream
     */
    fun getTopics(): Flow<List<Topic>>

    /**
     * Gets data for a specific topic
     */
    fun getTopic(id: String): Flow<Topic>
}
