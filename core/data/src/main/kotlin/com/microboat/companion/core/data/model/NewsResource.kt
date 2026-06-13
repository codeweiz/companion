/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.data.model

import com.microboat.companion.core.database.model.NewsResourceEntity
import com.microboat.companion.core.database.model.NewsResourceTopicCrossRef
import com.microboat.companion.core.database.model.TopicEntity
import com.microboat.companion.core.model.data.NewsResource
import com.microboat.companion.core.network.model.NetworkNewsResource
import com.microboat.companion.core.network.model.NetworkTopic
import com.microboat.companion.core.network.model.asExternalModel

fun NetworkNewsResource.asEntity() = NewsResourceEntity(
    id = id,
    title = title,
    content = content,
    url = url,
    headerImageUrl = headerImageUrl,
    publishDate = publishDate,
    type = type,
)

/**
 * A shell [TopicEntity] to fulfill the foreign key constraint when inserting
 * a [NewsResourceEntity] into the DB
 */
fun NetworkNewsResource.topicEntityShells() =
    topics.map { topicId ->
        TopicEntity(
            id = topicId,
            name = "",
            url = "",
            imageUrl = "",
            shortDescription = "",
            longDescription = "",
        )
    }

fun NetworkNewsResource.topicCrossReferences(): List<NewsResourceTopicCrossRef> =
    topics.map { topicId ->
        NewsResourceTopicCrossRef(
            newsResourceId = id,
            topicId = topicId,
        )
    }

fun NetworkNewsResource.asExternalModel(topics: List<NetworkTopic>) =
    NewsResource(
        id = id,
        title = title,
        content = content,
        url = url,
        headerImageUrl = headerImageUrl,
        publishDate = publishDate,
        type = type,
        topics = topics
            .filter { networkTopic -> this.topics.contains(networkTopic.id) }
            .map(NetworkTopic::asExternalModel),
    )
