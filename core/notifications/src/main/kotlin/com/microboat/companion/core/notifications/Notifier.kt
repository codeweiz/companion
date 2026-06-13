/*
 * Copyright 2023 microboat. All rights reserved.
 */
package com.microboat.companion.core.notifications

import com.microboat.companion.core.model.data.NewsResource

/**
 * Interface for creating notifications in the app
 */
interface Notifier {
    fun postNewsNotifications(newsResources: List<NewsResource>)
}
