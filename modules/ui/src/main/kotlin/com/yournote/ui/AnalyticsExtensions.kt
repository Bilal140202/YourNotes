/*
 *abiola 2024
 */

package com.yournote.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.yournote.analytics.AnalyticsEvent
import com.yournote.analytics.AnalyticsEvent.Param
import com.yournote.analytics.AnalyticsEvent.ParamKeys
import com.yournote.analytics.AnalyticsEvent.Types
import com.yournote.analytics.AnalyticsHelper
import com.yournote.analytics.LocalAnalyticsHelper

/**
 * Classes and functions associated with analytics events for the UI.
 */
fun AnalyticsHelper.logScreenView(screenName: String) {
    logEvent(
        AnalyticsEvent(
            type = Types.SCREEN_VIEW,
            extras = listOf(
                Param(ParamKeys.SCREEN_NAME, screenName),
            ),
        ),
    )
}

fun AnalyticsHelper.logNoteOpened(newsResourceId: String) {
    logEvent(
        event = AnalyticsEvent(
            type = "open_opened",
            extras = listOf(
                Param("open_opened", newsResourceId),
            ),
        ),
    )
}

/**
 * A side-effect which records a screen view event.
 */
@Composable
fun TrackScreenViewEvent(
    screenName: String,
    analyticsHelper: AnalyticsHelper = LocalAnalyticsHelper.current,
) = DisposableEffect(Unit) {
    analyticsHelper.logScreenView(screenName)
    onDispose {}
}
