/*
 * YourNotes
 * Copyright (c) 2026 Bilal Ansari. All rights reserved.
 */

package com.yournote.data.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/**
 * Network monitor stub - always returns online since YourNotes is fully offline.
 */
internal class ConnectivityManagerNetworkMonitor @Inject constructor() : NetworkMonitor {
    override val isOnline: Flow<Boolean> = flowOf(true)
}
