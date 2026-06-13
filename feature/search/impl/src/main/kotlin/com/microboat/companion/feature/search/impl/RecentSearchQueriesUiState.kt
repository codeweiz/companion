/*
 * Copyright 2023 microboat. All rights reserved.
 */
package com.microboat.companion.feature.search.impl

import com.microboat.companion.core.data.model.RecentSearchQuery

sealed interface RecentSearchQueriesUiState {
    data object Loading : RecentSearchQueriesUiState

    data class Success(
        val recentQueries: List<RecentSearchQuery> = emptyList(),
    ) : RecentSearchQueriesUiState
}
