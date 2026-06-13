/*
 * Copyright 2024 microboat. All rights reserved.
 */
package com.microboat.companion.ui

import androidx.annotation.StringRes
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import kotlin.properties.ReadOnlyProperty

fun AndroidComposeTestRule<*, *>.stringResource(
    @StringRes resId: Int,
): ReadOnlyProperty<Any, String> =
    ReadOnlyProperty { _, _ -> activity.getString(resId) }
