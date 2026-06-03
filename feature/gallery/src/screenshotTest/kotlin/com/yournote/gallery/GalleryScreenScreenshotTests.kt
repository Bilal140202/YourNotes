/*
 *abiola 2023
 */

package com.yournote.gallery

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.yournote.model.NoteImage
import com.yournote.ui.PreviewContainer
import com.yournote.ui.PreviewMain

class GalleryScreenScreenshotTests {
    @OptIn(ExperimentalSharedTransitionApi::class)
    @PreviewMain
    @Composable
    fun Main() {
        PreviewContainer {
            GalleryScreen(
                galleryUiState = GalleryUiState(
                    images = listOf(
                        NoteImage(id = 1),
                    ),

                ),
                pagerState = rememberPagerState(0) { 1 },
            )
        }
    }
}
