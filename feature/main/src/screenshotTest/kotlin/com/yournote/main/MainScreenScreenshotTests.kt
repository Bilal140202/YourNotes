/*
 *abiola 2023
 */

package com.yournote.main

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.Composable
import com.yournote.model.NoteDisplayCategory
import com.yournote.model.getDefinedNotePads
import com.yournote.ui.PreviewContainer
import com.yournote.ui.PreviewMain

class MainScreenScreenshotTests {

    @OptIn(ExperimentalSharedTransitionApi::class)
    @PreviewMain
    @Composable
    fun Main() {
        val list = getDefinedNotePads()
        val pin = list.take(3)
        val unPin = list.takeLast(7)

        PreviewContainer {
            MainScreen(
                mainState = MainState.Success(
                    isGrid = true,
                    labelName = "Label",
                    pinNotePads = pin,
                    unPinNotePads = unPin,
                    noteDisplayCategory = NoteDisplayCategory(),
                    selectState = null,
                ),
            )
        }
    }

    @OptIn(ExperimentalSharedTransitionApi::class)
    @PreviewMain
    @Composable
    fun MainEmptyScreenShot() {
        PreviewContainer {
            MainScreen(
                mainState = MainState.Success(
                    isGrid = true,
                    labelName = "Label",
                    noteDisplayCategory = NoteDisplayCategory(),
                    selectState = null,
                ),
            )
        }
    }

    @OptIn(ExperimentalSharedTransitionApi::class)
    @PreviewMain
    @Composable
    fun Loading() {
        PreviewContainer {
            MainScreen(
                mainState = MainState.Loading,
            )
        }
    }
}
