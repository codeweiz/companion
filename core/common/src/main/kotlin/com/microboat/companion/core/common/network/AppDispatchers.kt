/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.common.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val niaDispatcher: AppDispatchers)

enum class AppDispatchers {
    Default,
    IO,
}
