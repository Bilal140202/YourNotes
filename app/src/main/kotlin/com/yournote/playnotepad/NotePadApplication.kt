/*
 * YourNotes
 * Copyright (c) 2026 Bilal Ansari. All rights reserved.
 */

package com.yournote.notepad

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class NotePadApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (packageName.endsWith(".debug")) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
