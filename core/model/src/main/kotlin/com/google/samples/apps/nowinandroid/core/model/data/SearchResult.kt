/*
 * Copyright 2023 microboat. All rights reserved.
 */
package com.google.samples.apps.nowinandroid.core.model.data

/** An entity that holds the search result */
data class SearchResult(
    val topics: List<Topic> = emptyList(),
    val newsResources: List<NewsResource> = emptyList(),
)
