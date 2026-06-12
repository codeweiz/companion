/*
 * Copyright 2023 microboat. All rights reserved.
 */
package com.google.samples.apps.nowinandroid.core.analytics

/**
 * Implementation of AnalyticsHelper which does nothing. Useful for tests and previews.
 */
class NoOpAnalyticsHelper : AnalyticsHelper {
    override fun logEvent(event: AnalyticsEvent) = Unit
}
