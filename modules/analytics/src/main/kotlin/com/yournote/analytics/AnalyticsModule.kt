/*
 * YourNotes
 * Copyright (c) 2026 Bilal Ansari. All rights reserved.
 */

package com.yournote.analytics

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class AnalyticsModule {
    @Binds
    abstract fun bindsAnalyticsHelper(impl: NoOpAnalyticsHelper): AnalyticsHelper
}
