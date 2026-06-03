/*
 *abiola 2023
 */

package com.yournote.detail

import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import com.yournote.model.Label
import com.yournote.model.Note
import com.yournote.model.NoteDrawing
import com.yournote.model.NoteImage
import com.yournote.model.NotePad
import com.yournote.model.NoteUri
import com.yournote.model.NoteVoice
import com.yournote.ui.PreviewContainer
import com.yournote.ui.PreviewMain

class DetailScreenScreenshotTests {

    @PreviewMain
    @Composable
    private fun Main() {
        PreviewContainer {
            DetailScreen(
                state = DetailState(
                    notePad = NotePad(
                        note = Note(),
                        images = listOf(
                            NoteImage(1, 2, ""),
                        ),
                        drawings = listOf(
                            NoteDrawing(1, 2),
                        ),
                        labels = listOf(
                            Label(1, "label"),
                            Label(2, "label2"),
                        ),
                        uris = listOf(
                            NoteUri(1, "", "Path", "akdkdk"),
                        ),
                        voices = listOf(
                            NoteVoice(1, 2, ""),
                        ),
//                        notification = NotificationUiState(
//                            currentPlace = NotificationPlace.Work,
//                            currentDateTime = LocalDateTime(2025,2,25,12,60,1),
//                            currentInterval = NotificationInterval.Daily(intervalEnd = IntervalEnd.Forever)
//                        )

                    ),
                    title = rememberTextFieldState("Title"),
                    detail = rememberTextFieldState("Detail"),
                ),
            )
        }
    }

    @PreviewMain
    @Composable
    private fun MainCheck() {
        PreviewContainer {
            DetailScreen(
                state = DetailState(
                    notePad = NotePad(
                        note = Note(),
                        images = listOf(
                            NoteImage(1, 2, ""),
                        ),
                        drawings = listOf(
                            NoteDrawing(1, 2),
                        ),
                        labels = listOf(
                            Label(1, "label"),
                            Label(2, "label2"),
                        ),
                        uris = listOf(
                            NoteUri(1, "", "Path", "akdkdk"),
                        ),
                        voices = listOf(
                            NoteVoice(1, 2, ""),
                        ),
//                        notification = NotificationUiState(
//                            currentPlace = NotificationPlace.Work,
//                            currentDateTime = LocalDateTime(2025,2,25,12,60,1),
//                            currentInterval = NotificationInterval.Daily(intervalEnd = IntervalEnd.Forever)
//                        )

                    ),
                    title = rememberTextFieldState("Title"),
                    detail = rememberTextFieldState("Detail"),
                ),
            )
        }
    }
}
