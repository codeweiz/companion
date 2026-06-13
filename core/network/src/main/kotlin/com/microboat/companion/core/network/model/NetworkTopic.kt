/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.network.model

import com.microboat.companion.core.model.data.Topic
import kotlinx.serialization.Serializable

/**
 * Network representation of [Topic]
 */
@Serializable
data class NetworkTopic(
    val id: String,
    val name: String = "",
    val shortDescription: String = "",
    val longDescription: String = "",
    val url: String = "",
    val imageUrl: String = "",
    val followed: Boolean = false,
)

fun NetworkTopic.asExternalModel(): Topic =
    Topic(
        id = id,
        name = name,
        shortDescription = shortDescription,
        longDescription = longDescription,
        url = url,
        imageUrl = imageUrl,
    )
