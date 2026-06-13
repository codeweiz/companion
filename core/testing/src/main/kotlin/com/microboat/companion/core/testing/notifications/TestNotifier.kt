/*
 * Copyright 2023 microboat. All rights reserved.
 */
package com.microboat.companion.core.testing.notifications

import com.microboat.companion.core.model.data.NewsResource
import com.microboat.companion.core.notifications.Notifier

/**
 * Aggregates news resources that have been notified for addition
 */
class TestNotifier : Notifier {

    private val mutableAddedNewResources = mutableListOf<List<NewsResource>>()

    val addedNewsResources: List<List<NewsResource>> = mutableAddedNewResources

    override fun postNewsNotifications(newsResources: List<NewsResource>) {
        mutableAddedNewResources.add(newsResources)
    }
}
