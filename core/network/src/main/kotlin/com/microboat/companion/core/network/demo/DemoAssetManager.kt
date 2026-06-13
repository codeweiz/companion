/*
 * Copyright 2024 microboat. All rights reserved.
 */
package com.microboat.companion.core.network.demo

import java.io.InputStream

fun interface DemoAssetManager {
    fun open(fileName: String): InputStream
}
