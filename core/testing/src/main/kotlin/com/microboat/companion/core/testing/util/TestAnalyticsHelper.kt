/*
 * Copyright 2023 microboat. All rights reserved.
 */
package com.microboat.companion.core.testing.util

import com.microboat.companion.core.analytics.AnalyticsEvent
import com.microboat.companion.core.analytics.AnalyticsHelper

class TestAnalyticsHelper : AnalyticsHelper {

    private val events = mutableListOf<AnalyticsEvent>()
    override fun logEvent(event: AnalyticsEvent) {
        events.add(event)
    }

    fun hasLogged(event: AnalyticsEvent) = event in events
}
