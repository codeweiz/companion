/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.model.data

/**
 * External data layer representation of a NiA Topic
 */
data class Topic(
    val id: String,
    val name: String,
    val shortDescription: String,
    val longDescription: String,
    val url: String,
    val imageUrl: String,
)
