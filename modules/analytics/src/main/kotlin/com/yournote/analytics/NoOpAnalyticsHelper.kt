/*
 * YourNotes
 * Copyright (c) 2026 Bilal Ansari. All rights reserved.
 */

package com.yournote.analytics

import javax.inject.Inject

/**
 * Implementation of AnalyticsHelper which does nothing. Used for fully offline app.
 */
class NoOpAnalyticsHelper @Inject constructor() : AnalyticsHelper {
    override fun logEvent(event: AnalyticsEvent) = Unit
}
