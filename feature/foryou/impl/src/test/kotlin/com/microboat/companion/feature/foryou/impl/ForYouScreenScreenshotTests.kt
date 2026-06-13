/*
 * Copyright 2023 microboat. All rights reserved.
 */
package com.microboat.companion.feature.foryou.impl

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.android.apps.common.testing.accessibility.framework.AccessibilityCheckResultUtils
import com.google.android.apps.common.testing.accessibility.framework.AccessibilityCheckResultUtils.matchesElements
import com.google.android.apps.common.testing.accessibility.framework.checks.TextContrastCheck
import com.google.android.apps.common.testing.accessibility.framework.matcher.ElementMatchers.withText
import com.microboat.companion.core.designsystem.component.AppBackground
import com.microboat.companion.core.designsystem.theme.AppTheme
import com.microboat.companion.core.testing.util.DefaultTestDevices
import com.microboat.companion.core.testing.util.captureForDevice
import com.microboat.companion.core.testing.util.captureMultiDevice
import com.microboat.companion.core.ui.NewsFeedUiState
import com.microboat.companion.core.ui.NewsFeedUiState.Success
import com.microboat.companion.core.ui.UserNewsResourcePreviewParameterProvider
import com.microboat.companion.feature.foryou.impl.OnboardingUiState.NotShown
import com.microboat.companion.feature.foryou.impl.OnboardingUiState.Shown
import dagger.hilt.android.testing.HiltTestApplication
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode
import org.robolectric.annotation.LooperMode
import java.util.TimeZone

/**
 * Screenshot tests for the [ForYouScreen].
 */
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(application = HiltTestApplication::class)
@LooperMode(LooperMode.Mode.PAUSED)
class ForYouScreenScreenshotTests {

    /**
     * Use a test activity to set the content on.
     */
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val userNewsResources = UserNewsResourcePreviewParameterProvider().values.first()

    @Before
    fun setTimeZone() {
        // Make time zone deterministic in tests
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }

    @Test
    fun forYouScreenPopulatedFeed() {
        composeTestRule.captureMultiDevice("ForYouScreenPopulatedFeed") {
            AppTheme {
                ForYouScreen(
                    isSyncing = false,
                    onboardingUiState = NotShown,
                    feedState = Success(
                        feed = userNewsResources,
                    ),
                    onTopicCheckedChanged = { _, _ -> },
                    saveFollowedTopics = {},
                    onNewsResourcesCheckedChanged = { _, _ -> },
                    onNewsResourceViewed = {},
                    onTopicClick = {},
                    deepLinkedUserNewsResource = null,
                    onDeepLinkOpened = {},
                )
            }
        }
    }

    @Test
    fun forYouScreenLoading() {
        composeTestRule.captureMultiDevice("ForYouScreenLoading") {
            AppTheme {
                ForYouScreen(
                    isSyncing = false,
                    onboardingUiState = OnboardingUiState.Loading,
                    feedState = NewsFeedUiState.Loading,
                    onTopicCheckedChanged = { _, _ -> },
                    saveFollowedTopics = {},
                    onNewsResourcesCheckedChanged = { _, _ -> },
                    onNewsResourceViewed = {},
                    onTopicClick = {},
                    deepLinkedUserNewsResource = null,
                    onDeepLinkOpened = {},
                )
            }
        }
    }

    @Test
    fun forYouScreenTopicSelection() {
        composeTestRule.captureMultiDevice(
            "ForYouScreenTopicSelection",
            accessibilitySuppressions = Matchers.allOf(
                AccessibilityCheckResultUtils.matchesCheck(TextContrastCheck::class.java),
                Matchers.anyOf(
                    // Disabled Button
                    matchesElements(withText("Done")),

                    // TODO investigate, seems a false positive
                    matchesElements(withText("What are you interested in?")),
                    matchesElements(withText("UI")),
                ),
            ),
        ) {
            ForYouScreenTopicSelection()
        }
    }

    @Test
    fun forYouScreenTopicSelection_dark() {
        composeTestRule.captureForDevice(
            deviceName = "phone_dark",
            deviceSpec = DefaultTestDevices.PHONE.spec,
            screenshotName = "ForYouScreenTopicSelection",
            darkMode = true,
        ) {
            ForYouScreenTopicSelection()
        }
    }

    @Test
    fun forYouScreenPopulatedAndLoading() {
        composeTestRule.captureMultiDevice("ForYouScreenPopulatedAndLoading") {
            ForYouScreenPopulatedAndLoading()
        }
    }

    @Test
    fun forYouScreenPopulatedAndLoading_dark() {
        composeTestRule.captureForDevice(
            deviceName = "phone_dark",
            deviceSpec = DefaultTestDevices.PHONE.spec,
            screenshotName = "ForYouScreenPopulatedAndLoading",
            darkMode = true,
        ) {
            ForYouScreenPopulatedAndLoading()
        }
    }

    @Composable
    private fun ForYouScreenTopicSelection() {
        AppTheme {
            AppBackground {
                ForYouScreen(
                    isSyncing = false,
                    onboardingUiState = Shown(
                        topics = userNewsResources.flatMap { news -> news.followableTopics }
                            .distinctBy { it.topic.id },
                    ),
                    feedState = Success(
                        feed = userNewsResources,
                    ),
                    onTopicCheckedChanged = { _, _ -> },
                    saveFollowedTopics = {},
                    onNewsResourcesCheckedChanged = { _, _ -> },
                    onNewsResourceViewed = {},
                    onTopicClick = {},
                    deepLinkedUserNewsResource = null,
                    onDeepLinkOpened = {},
                )
            }
        }
    }

    @Composable
    private fun ForYouScreenPopulatedAndLoading() {
        AppTheme {
            AppBackground {
                AppTheme {
                    ForYouScreen(
                        isSyncing = true,
                        onboardingUiState = OnboardingUiState.Loading,
                        feedState = Success(
                            feed = userNewsResources,
                        ),
                        onTopicCheckedChanged = { _, _ -> },
                        saveFollowedTopics = {},
                        onNewsResourcesCheckedChanged = { _, _ -> },
                        onNewsResourceViewed = {},
                        onTopicClick = {},
                        deepLinkedUserNewsResource = null,
                        onDeepLinkOpened = {},
                    )
                }
            }
        }
    }
}
