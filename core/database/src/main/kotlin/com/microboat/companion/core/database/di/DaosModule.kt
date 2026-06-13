/*
 * Copyright 2024 microboat. All rights reserved.
 */
package com.microboat.companion.core.database.di

import com.microboat.companion.core.database.AppDatabase
import com.microboat.companion.core.database.dao.NewsResourceDao
import com.microboat.companion.core.database.dao.NewsResourceFtsDao
import com.microboat.companion.core.database.dao.RecentSearchQueryDao
import com.microboat.companion.core.database.dao.TopicDao
import com.microboat.companion.core.database.dao.TopicFtsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaosModule {
    @Provides
    fun providesTopicsDao(
        database: AppDatabase,
    ): TopicDao = database.topicDao()

    @Provides
    fun providesNewsResourceDao(
        database: AppDatabase,
    ): NewsResourceDao = database.newsResourceDao()

    @Provides
    fun providesTopicFtsDao(
        database: AppDatabase,
    ): TopicFtsDao = database.topicFtsDao()

    @Provides
    fun providesNewsResourceFtsDao(
        database: AppDatabase,
    ): NewsResourceFtsDao = database.newsResourceFtsDao()

    @Provides
    fun providesRecentSearchQueryDao(
        database: AppDatabase,
    ): RecentSearchQueryDao = database.recentSearchQueryDao()
}
