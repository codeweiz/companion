/*
 * Copyright 2025 microboat. All rights reserved.
 */
package com.microboat.companion.feature.search.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.microboat.companion.core.navigation.Navigator
import com.microboat.companion.feature.interests.api.navigation.InterestsNavKey
import com.microboat.companion.feature.search.api.navigation.SearchNavKey
import com.microboat.companion.feature.search.impl.SearchScreen
import com.microboat.companion.feature.topic.api.navigation.navigateToTopic

fun EntryProviderScope<NavKey>.searchEntry(navigator: Navigator) {
    entry<SearchNavKey> {
        SearchScreen(
            onBackClick = { navigator.goBack() },
            onInterestsClick = { navigator.navigate(InterestsNavKey()) },
            onTopicClick = navigator::navigateToTopic,
        )
    }
}
