/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.data.test.repository

import com.microboat.companion.core.data.repository.UserDataRepository
import com.microboat.companion.core.datastore.AppPreferencesDataSource
import com.microboat.companion.core.model.data.DarkThemeConfig
import com.microboat.companion.core.model.data.ThemeBrand
import com.microboat.companion.core.model.data.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Fake implementation of the [UserDataRepository] that returns hardcoded user data.
 *
 * This allows us to run the app with fake data, without needing an internet connection or working
 * backend.
 */
class FakeUserDataRepository @Inject constructor(
    private val niaPreferencesDataSource: AppPreferencesDataSource,
) : UserDataRepository {

    override val userData: Flow<UserData> =
        niaPreferencesDataSource.userData

    override suspend fun setFollowedTopicIds(followedTopicIds: Set<String>) =
        niaPreferencesDataSource.setFollowedTopicIds(followedTopicIds)

    override suspend fun setTopicIdFollowed(followedTopicId: String, followed: Boolean) =
        niaPreferencesDataSource.setTopicIdFollowed(followedTopicId, followed)

    override suspend fun setNewsResourceBookmarked(newsResourceId: String, bookmarked: Boolean) {
        niaPreferencesDataSource.setNewsResourceBookmarked(newsResourceId, bookmarked)
    }

    override suspend fun setNewsResourceViewed(newsResourceId: String, viewed: Boolean) =
        niaPreferencesDataSource.setNewsResourceViewed(newsResourceId, viewed)

    override suspend fun setThemeBrand(themeBrand: ThemeBrand) {
        niaPreferencesDataSource.setThemeBrand(themeBrand)
    }

    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        niaPreferencesDataSource.setDarkThemeConfig(darkThemeConfig)
    }

    override suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
        niaPreferencesDataSource.setDynamicColorPreference(useDynamicColor)
    }

    override suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) {
        niaPreferencesDataSource.setShouldHideOnboarding(shouldHideOnboarding)
    }
}
