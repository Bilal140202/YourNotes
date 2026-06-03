/*
 *abiola 2022
 */

package com.yournote.benchmarks.baselineprofile

import androidx.benchmark.macro.junit4.BaselineProfileRule
import com.yournote.benchmarks.PACKAGE_NAME
import com.yournote.benchmarks.detail.addNote
import com.yournote.benchmarks.detail.goBack
import com.yournote.benchmarks.main.goToDetailScreen
import com.yournote.benchmarks.main.mainScrollNoteDownUp
import org.junit.Rule
import org.junit.Test

class GenerateBaselineProfile {
    @get:Rule
    val baselineProfileRule = BaselineProfileRule()

    @Test
    fun generate() =
        baselineProfileRule.collect(PACKAGE_NAME) {
            pressHome()
            startActivityAndWait()

            device.waitForIdle()

            goToDetailScreen()
            addNote()
            goBack()

            mainScrollNoteDownUp()
        }
}
