/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.data.di

import com.microboat.companion.core.data.repository.DefaultRecentSearchRepository
import com.microboat.companion.core.data.repository.DefaultSearchContentsRepository
import com.microboat.companion.core.data.repository.NewsRepository
import com.microboat.companion.core.data.repository.OfflineFirstNewsRepository
import com.microboat.companion.core.data.repository.OfflineFirstTopicsRepository
import com.microboat.companion.core.data.repository.OfflineFirstUserDataRepository
import com.microboat.companion.core.data.repository.RecentSearchRepository
import com.microboat.companion.core.data.repository.SearchContentsRepository
import com.microboat.companion.core.data.repository.TopicsRepository
import com.microboat.companion.core.data.repository.UserDataRepository
import com.microboat.companion.core.data.util.ConnectivityManagerNetworkMonitor
import com.microboat.companion.core.data.util.NetworkMonitor
import com.microboat.companion.core.data.util.TimeZoneBroadcastMonitor
import com.microboat.companion.core.data.util.TimeZoneMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsTopicRepository(
        topicsRepository: OfflineFirstTopicsRepository,
    ): TopicsRepository

    @Binds
    internal abstract fun bindsNewsResourceRepository(
        newsRepository: OfflineFirstNewsRepository,
    ): NewsRepository

    @Binds
    internal abstract fun bindsUserDataRepository(
        userDataRepository: OfflineFirstUserDataRepository,
    ): UserDataRepository

    @Binds
    internal abstract fun bindsRecentSearchRepository(
        recentSearchRepository: DefaultRecentSearchRepository,
    ): RecentSearchRepository

    @Binds
    internal abstract fun bindsSearchContentsRepository(
        searchContentsRepository: DefaultSearchContentsRepository,
    ): SearchContentsRepository

    @Binds
    internal abstract fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor

    @Binds
    internal abstract fun binds(impl: TimeZoneBroadcastMonitor): TimeZoneMonitor
}
