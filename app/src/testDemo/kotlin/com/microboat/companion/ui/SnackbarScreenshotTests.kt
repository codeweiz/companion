/*
 * Copyright 2023 microboat. All rights reserved.
 */
package com.microboat.companion.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.SnackbarDuration.Indefinite
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.adaptive.Posture
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.test.DeviceConfigurationOverride
import androidx.compose.ui.test.ForcedSize
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass
import com.github.takahirom.roborazzi.captureRoboImage
import com.microboat.companion.core.data.repository.TopicsRepository
import com.microboat.companion.core.data.repository.UserNewsResourceRepository
import com.microboat.companion.core.data.test.repository.FakeUserDataRepository
import com.microboat.companion.core.data.util.NetworkMonitor
import com.microboat.companion.core.data.util.TimeZoneMonitor
import com.microboat.companion.core.designsystem.theme.AppTheme
import com.microboat.companion.core.testing.util.DefaultRoborazziOptions
import com.microboat.companion.feature.bookmarks.impl.navigation.LocalSnackbarHostState
import com.microboat.companion.uitesthiltmanifest.HiltComponentActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode
import org.robolectric.annotation.LooperMode
import java.util.TimeZone
import javax.inject.Inject

/**
 * Tests that the Snackbar is correctly displayed on different screen sizes.
 */
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
// Configure Robolectric to use a very large screen size that can fit all of the test sizes.
// This allows enough room to render the content under test without clipping or scaling.
@Config(application = HiltTestApplication::class, qualifiers = "w1000dp-h1000dp-480dpi")
@LooperMode(LooperMode.Mode.PAUSED)
@HiltAndroidTest
class SnackbarScreenshotTests {

    /**
     * Manages the components' state and is used to perform injection on your test
     */
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    /**
     * Use a test activity to set the content on.
     */
    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<HiltComponentActivity>()

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    @Inject
    lateinit var timeZoneMonitor: TimeZoneMonitor

    @Inject
    lateinit var userDataRepository: FakeUserDataRepository

    @Inject
    lateinit var topicsRepository: TopicsRepository

    @Inject
    lateinit var userNewsResourceRepository: UserNewsResourceRepository

    @Before
    fun setup() {
        hiltRule.inject()

        // Configure user data
        runBlocking {
            userDataRepository.setShouldHideOnboarding(true)

            userDataRepository.setFollowedTopicIds(
                setOf(topicsRepository.getTopics().first().first().id),
            )
        }
    }

    @Before
    fun setTimeZone() {
        // Make time zone deterministic in tests
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }

    @Test
    fun phone_noSnackbar() {
        testSnackbarScreenshotWithSize(
            400.dp,
            500.dp,
            "snackbar_compact_medium_noSnackbar",
            action = { },
        )
    }

    @Test
    fun snackbarShown_phone() {
        testSnackbarScreenshotWithSize(
            400.dp,
            500.dp,
            "snackbar_compact_medium",
        ) { snackbarHostState ->
            snackbarHostState.showSnackbar(
                "This is a test snackbar message",
                actionLabel = "Action Label",
                duration = Indefinite,
            )
        }
    }

    @Test
    fun snackbarShown_foldable() {
        testSnackbarScreenshotWithSize(
            600.dp,
            600.dp,
            "snackbar_medium_medium",
        ) { snackbarHostState ->
            snackbarHostState.showSnackbar(
                "This is a test snackbar message",
                actionLabel = "Action Label",
                duration = Indefinite,
            )
        }
    }

    @Test
    fun snackbarShown_tablet() {
        testSnackbarScreenshotWithSize(
            900.dp,
            900.dp,
            "snackbar_expanded_expanded",
        ) { snackbarHostState ->
            snackbarHostState.showSnackbar(
                "This is a test snackbar message",
                actionLabel = "Action Label",
                duration = Indefinite,
            )
        }
    }

    @Suppress("DEPRECATION")
    private fun testSnackbarScreenshotWithSize(
        width: Dp,
        height: Dp,
        screenshotName: String,
        action: suspend (snackbarHostState: SnackbarHostState) -> Unit,
    ) {
        lateinit var scope: CoroutineScope
        val snackbarHostState = SnackbarHostState()
        composeTestRule.setContent {
            CompositionLocalProvider(
                // Replaces images with placeholders
                LocalInspectionMode provides true,
                LocalSnackbarHostState provides snackbarHostState,

            ) {
                scope = rememberCoroutineScope()

                DeviceConfigurationOverride(
                    DeviceConfigurationOverride.ForcedSize(DpSize(width, height)),
                ) {
                    BoxWithConstraints {
                        AppTheme {
                            val appState = rememberNiaAppState(
                                networkMonitor = networkMonitor,
                                userNewsResourceRepository = userNewsResourceRepository,
                                timeZoneMonitor = timeZoneMonitor,
                            )
                            App(
                                appState = appState,
                                showSettingsDialog = false,
                                onSettingsDismissed = {},
                                onTopAppBarActionClick = {},
                                windowAdaptiveInfo = WindowAdaptiveInfo(
                                    windowSizeClass = WindowSizeClass.compute(
                                        maxWidth.value,
                                        maxHeight.value,
                                    ),
                                    windowPosture = Posture(),
                                ),
                            )
                        }
                    }
                }
            }
        }

        scope.launch {
            action(snackbarHostState)
        }

        composeTestRule.onRoot()
            .captureRoboImage(
                "src/testDemo/screenshots/$screenshotName.png",
                roborazziOptions = DefaultRoborazziOptions,
            )
    }
}
