/*
 * YourNotes
 * Licensed under GPL-3.0
 */

package com.yournote.analytics

import javax.inject.Inject

/**
 * Implementation of AnalyticsHelper which does nothing. Used for fully offline app.
 */
class NoOpAnalyticsHelper @Inject constructor() : AnalyticsHelper {
    override fun logEvent(event: AnalyticsEvent) = Unit
}
