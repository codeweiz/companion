/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.feature.topic.api.navigation

import androidx.navigation3.runtime.NavKey
import com.microboat.companion.core.navigation.Navigator
import kotlinx.serialization.Serializable

@Serializable
data class TopicNavKey(val id: String) : NavKey

fun Navigator.navigateToTopic(
    topicId: String,
) {
    navigate(TopicNavKey(topicId))
}
