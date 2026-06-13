/*
 * Copyright 2023 microboat. All rights reserved.
 */
package com.microboat.companion.core.analytics

/**
 * Interface for logging analytics events. See `FirebaseAnalyticsHelper` and
 * `StubAnalyticsHelper` for implementations.
 */
interface AnalyticsHelper {
    fun logEvent(event: AnalyticsEvent)
}
