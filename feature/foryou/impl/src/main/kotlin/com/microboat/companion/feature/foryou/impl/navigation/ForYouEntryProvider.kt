/*
 * Copyright 2025 microboat. All rights reserved.
 */
package com.microboat.companion.feature.foryou.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.microboat.companion.core.navigation.Navigator
import com.microboat.companion.feature.foryou.api.navigation.ForYouNavKey
import com.microboat.companion.feature.foryou.impl.ForYouScreen
import com.microboat.companion.feature.topic.api.navigation.navigateToTopic

fun EntryProviderScope<NavKey>.forYouEntry(navigator: Navigator) {
    entry<ForYouNavKey> {
        ForYouScreen(
            onTopicClick = navigator::navigateToTopic,
        )
    }
}
