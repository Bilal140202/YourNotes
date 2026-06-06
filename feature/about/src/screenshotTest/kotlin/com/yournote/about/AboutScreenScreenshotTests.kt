/*
 *abiola 2023
 */

package com.yournote.about

import androidx.compose.runtime.Composable
import com.yournote.ui.PreviewContainer
import com.yournote.ui.PreviewMain

class AboutScreenScreenshotTests {

    @PreviewMain
    @Composable
    private fun Main() {
        PreviewContainer {
            AboutScreen(
                lastUpdate = "12-20-20025",
                version = "2.4.3",
            )
        }
    }
}
