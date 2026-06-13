/*
 * Copyright 2024 microboat. All rights reserved.
 */
package com.microboat.companion.core.data.test

import com.microboat.companion.core.data.util.TimeZoneMonitor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.datetime.TimeZone
import javax.inject.Inject

class DefaultZoneIdTimeZoneMonitor @Inject constructor() : TimeZoneMonitor {
    override val currentTimeZone: Flow<TimeZone> = flowOf(TimeZone.of("Europe/Warsaw"))
}
