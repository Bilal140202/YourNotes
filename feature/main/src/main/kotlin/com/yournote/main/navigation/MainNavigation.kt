/*
 *abiola 2022
 */

package com.yournote.main.navigation

import android.content.Intent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ShareCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import com.yournote.main.DeleteForeverDialog
import com.yournote.main.DeleteLabelAlertDialog
import com.yournote.main.EmptyTrashDialog
import com.yournote.main.MainScreen
import com.yournote.main.MainState
import com.yournote.main.MainViewModel
import com.yournote.main.RenameLabelAlertDialog
import com.yournote.ui.ColorDialog
import com.yournote.ui.NotificationDialogNew
import kotlinx.serialization.Serializable

@Serializable
data object Main : NavKey

fun NavBackStack.navigateToMain() {
    add(Main)
}

@OptIn(ExperimentalSharedTransitionApi::class)
fun EntryProviderBuilder<NavKey>.main(
    modifier: Modifier = Modifier,
    navigateToDetail: (Long, Int, Int) -> Unit,
    navigateToSelectLevel: (Set<Long>) -> Unit,
    onOpenDrawer: () -> Unit,
    navigateToSearch: () -> Unit,
) {
    entry<Main> {
        val mainViewModel: MainViewModel = hiltViewModel()
        val mainState = mainViewModel.mainState.collectAsStateWithLifecycle()

//        LaunchedEffect(
//            key1 = Unit,
//            block = {
//                delay(2000)
//                mainViewModel.deleteEmptyNote()
//            },
//        )

        var showDialog by remember {
            mutableStateOf(false)
        }
        var showColor by remember {
            mutableStateOf(false)
        }
        var showRenameLabel by remember {
            mutableStateOf(false)
        }
        var showDeleteLabel by remember {
            mutableStateOf(false)
        }
        var showDeleteForever by remember {
            mutableStateOf(false)
        }
        var showEmptyTrash by remember {
            mutableStateOf(false)
        }
        val context = LocalContext.current

        MainScreen(
            modifier = modifier,
            mainState = mainState.value,
            navigateToNoteEditor = navigateToDetail,
            onNoteSelected = mainViewModel::handleCardSelection,
            onClearSelection = mainViewModel::deselectNotes,
            onPinNotes = mainViewModel::pinOrUnpinNotes,
            onNotificationClick = { showDialog = true },
            onSelectColor = { showColor = true },
            onLabelNotes = {
                (mainState.value as MainState.Success).selectState?.setOfSelected?.let {
                    navigateToSelectLevel(it)
                }
            },
            onCopyNote = mainViewModel::onCopyNote,
            onDeleteNotes = mainViewModel::onDeleteNote,
            onArchive = mainViewModel::onArchiveNote,
            onShareNote = {
                val notePads = mainViewModel.onSendNote()
                val intent = ShareCompat.IntentBuilder(context)
                    .setText(notePads.toString())
                    .setType("text/*")
                    .setChooserTitle("From Notepad")
                    .createChooserIntent()
                context.startActivity(Intent(intent))
            },
            onLabelNameChange = { showRenameLabel = true },
            onDeleteLabel = { showDeleteLabel = true },
            onDeleteAllTrash = { showEmptyTrash = true },
            onHamburgerMenuClick = onOpenDrawer,
            onSearchClick = navigateToSearch,
            onDisplayModeChange = mainViewModel::onDisplayModeChange,
            onRestore = mainViewModel::onRestore,
            onDeletedForever = { showDeleteForever = true },
        )

        NotificationDialogNew(
            showDialog = showDialog,
            onDismissRequest = { showDialog = false },
            isEdit = false,
            initState = (mainState.value as? MainState.Success)?.selectState?.notificationUiState,
            onSetAlarm = mainViewModel::setAlarm,
            onDeleteAlarm = mainViewModel::onDeleteAlarm,
        )

        ColorDialog(
            show = showColor,
            onDismissRequest = { showColor = false },
            onColorClick = mainViewModel::setAllColor,
            currentColor = (mainState.value as? MainState.Success)?.selectState?.colorIndex ?: -1,
        )

        RenameLabelAlertDialog(
            show = showRenameLabel,
            label = (mainState.value as? MainState.Success)?.labelName ?: "",
            onDismissRequest = { showRenameLabel = false },
            onChangeName = mainViewModel::renameLabel,
        )

        DeleteLabelAlertDialog(
            show = showDeleteLabel,
            onDismissRequest = { showDeleteLabel = false },
            onDelete = mainViewModel::deleteLabel,
        )
        DeleteForeverDialog(
            show = showDeleteForever,
            onDismissRequest = { showDeleteForever = false },
            onDelete = mainViewModel::onDeleteForever,
        )

        EmptyTrashDialog(
            show = showEmptyTrash,
            onDismissRequest = { showEmptyTrash = false },
            onDelete = mainViewModel::onDeleteAllTrash,
        )
    }
}
