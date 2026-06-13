/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.network

import com.microboat.companion.core.network.model.NetworkChangeList
import com.microboat.companion.core.network.model.NetworkNewsResource
import com.microboat.companion.core.network.model.NetworkTopic

/**
 * Interface representing network calls to the NIA backend
 */
interface AppNetworkDataSource {
    suspend fun getTopics(ids: List<String>? = null): List<NetworkTopic>

    suspend fun getNewsResources(ids: List<String>? = null): List<NetworkNewsResource>

    suspend fun getTopicChangeList(after: Int? = null): List<NetworkChangeList>

    suspend fun getNewsResourceChangeList(after: Int? = null): List<NetworkChangeList>
}
