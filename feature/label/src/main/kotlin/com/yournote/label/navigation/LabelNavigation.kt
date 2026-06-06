package com.yournote.label.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import com.yournote.label.LabelScreen
import com.yournote.label.LabelViewModel
import com.yournote.labelscreen.LabelArg

fun EntryProviderBuilder<NavKey>.label(onBack: () -> Unit) {
    entry<LabelArg> { key ->
        val labelViewModel = hiltViewModel<LabelViewModel, LabelViewModel.Factory>(
            creationCallback = { factory -> factory.create(key) },
        )
        val labelUiState = labelViewModel.labelUiState.collectAsStateWithLifecycle()

        LabelScreen(
            labelUiState = labelUiState.value,
            onBack = onBack,
            onDelete = labelViewModel::onDelete,
            onAdd = labelViewModel::onAddNew,
        )
    }
}

fun NavBackStack.navigateToLabel(editMode: Boolean) {
    add(LabelArg(editMode))
}
