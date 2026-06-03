/*
 *abiola 2022
 */

package com.yournote.notepad.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.yournote.about.navigation.aboutScreen
import com.yournote.detail.navigation.DetailArg
import com.yournote.detail.navigation.detailScreen
import com.yournote.detail.navigation.navigateToDetail
import com.yournote.drawing.navigation.DrawingArgs
import com.yournote.drawing.navigation.drawingScreen
import com.yournote.drawing.navigation.navigateToDrawing
import com.yournote.gallery.navigation.GalleryArg
import com.yournote.gallery.navigation.gallery
import com.yournote.gallery.navigation.navigateToGallery
import com.yournote.label.navigation.label
import com.yournote.main.navigation.main
import com.yournote.notepad.ui.NoteAppState
import com.yournote.notepad.ui.pop
import com.yournote.search.navigation.navigateToSearch
import com.yournote.search.navigation.search
import com.yournote.selectlabel.navigation.navigateToSelectLabel
import com.yournote.selectlabel.navigation.selectLabelScreen
import com.yournote.setting.navigation.settingScreen
import com.yournote.ui.LocalSharedStScope

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun NoteNavHost2(
    appState: NoteAppState,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController

    SharedTransitionLayout(modifier = modifier) {
        CompositionLocalProvider(
            LocalSharedStScope provides this,
        ) {
            NavDisplay(
                backStack = navController,
                entryProvider = entryProvider {
                    main(
                        modifier = Modifier,
                        navigateToDetail = { id, colorIndex, background -> navController.navigateToDetail(DetailArg(id, colorIndex, background)) },
                        navigateToSelectLevel = appState.navController::navigateToSelectLabel,
                        onOpenDrawer = {
                            appState.openDrawer()
                        },
                        navigateToSearch = navController::navigateToSearch,
                    )
                    detailScreen(
                        modifier = Modifier,
                        onBack = navController::pop,
                        navigateToGallery = { id, index, total, currentPath ->
                            navController.navigateToGallery(
                                GalleryArg(id, index, total, currentPath),
                            )
                        },
                        navigateToDrawing = { noteId, image ->

                            navController.navigateToDrawing(
                                DrawingArgs(
                                    noteId,
                                    image,
                                ),
                            )
                        },
                        navigateToSelectLevel = navController::navigateToSelectLabel,
                    )
                    gallery(
                        onBack = navController::pop,
                    )
                    aboutScreen(onBack = navController::pop)
                    label(onBack = navController::pop)
                    selectLabelScreen(onBack = navController::pop)
                    drawingScreen(onBack = navController::pop)
                    settingScreen(
                        modifier = Modifier,
                        onBack = navController::pop,
                    )
                    search(
                        modifier = Modifier,
                        onBack = navController::pop,
                        navigateToDetail = { id, colorIndex, background ->
                            navController.navigateToDetail(
                                DetailArg(id, colorIndex, background),
                            )
                        },

                    )
                },
                entryDecorators = listOf(
                    rememberSavedStateNavEntryDecorator(),

                    rememberViewModelStoreNavEntryDecorator(),
                ),
            )
        }
    }
}
