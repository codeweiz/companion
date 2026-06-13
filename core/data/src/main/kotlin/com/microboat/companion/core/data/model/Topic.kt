/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.data.model

import com.microboat.companion.core.database.model.TopicEntity
import com.microboat.companion.core.network.model.NetworkTopic

fun NetworkTopic.asEntity() = TopicEntity(
    id = id,
    name = name,
    shortDescription = shortDescription,
    longDescription = longDescription,
    url = url,
    imageUrl = imageUrl,
)
