/*
 *abiola 2024
 */

package com.yournote.testing.util

import com.yournote.analytics.AnalyticsEvent
import com.yournote.analytics.AnalyticsHelper

class TestAnalyticsHelper : AnalyticsHelper {

    private val events = mutableListOf<AnalyticsEvent>()
    override fun logEvent(event: AnalyticsEvent) {
        events.add(event)
    }

    fun hasLogged(event: AnalyticsEvent) = event in events
}
