/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.data.repository

import com.microboat.companion.core.data.Synchronizer
import com.microboat.companion.core.data.changeListSync
import com.microboat.companion.core.data.model.asEntity
import com.microboat.companion.core.database.dao.TopicDao
import com.microboat.companion.core.database.model.TopicEntity
import com.microboat.companion.core.database.model.asExternalModel
import com.microboat.companion.core.datastore.ChangeListVersions
import com.microboat.companion.core.model.data.Topic
import com.microboat.companion.core.network.AppNetworkDataSource
import com.microboat.companion.core.network.model.NetworkTopic
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Disk storage backed implementation of the [TopicsRepository].
 * Reads are exclusively from local storage to support offline access.
 */
internal class OfflineFirstTopicsRepository @Inject constructor(
    private val topicDao: TopicDao,
    private val network: AppNetworkDataSource,
) : TopicsRepository {

    override fun getTopics(): Flow<List<Topic>> =
        topicDao.getTopicEntities()
            .map { it.map(TopicEntity::asExternalModel) }

    override fun getTopic(id: String): Flow<Topic> =
        topicDao.getTopicEntity(id).map { it.asExternalModel() }

    override suspend fun syncWith(synchronizer: Synchronizer): Boolean =
        synchronizer.changeListSync(
            versionReader = ChangeListVersions::topicVersion,
            changeListFetcher = { currentVersion ->
                network.getTopicChangeList(after = currentVersion)
            },
            versionUpdater = { latestVersion ->
                copy(topicVersion = latestVersion)
            },
            modelDeleter = topicDao::deleteTopics,
            modelUpdater = { changedIds ->
                val networkTopics = network.getTopics(ids = changedIds)
                topicDao.upsertTopics(
                    entities = networkTopics.map(NetworkTopic::asEntity),
                )
            },
        )
}
