/*
 * Copyright 2023 microboat. All rights reserved.
 */
@file:Suppress("ktlint:standard:max-line-length")

package com.microboat.companion.feature.search.impl

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.microboat.companion.core.model.data.FollowableTopic
import com.microboat.companion.core.ui.PreviewParameterData.newsResources
import com.microboat.companion.core.ui.PreviewParameterData.topics

/**
 * This [PreviewParameterProvider](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/PreviewParameterProvider)
 * provides list of [SearchResultUiState] for Composable previews.
 */
class SearchUiStatePreviewParameterProvider : PreviewParameterProvider<SearchResultUiState> {
    override val values: Sequence<SearchResultUiState> = sequenceOf(
        SearchResultUiState.Success(
            topics = topics.mapIndexed { i, topic ->
                FollowableTopic(topic = topic, isFollowed = i % 2 == 0)
            },
            newsResources = newsResources,
        ),
    )
}
