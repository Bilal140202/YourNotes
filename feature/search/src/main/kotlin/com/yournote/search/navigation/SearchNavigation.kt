/*
 *abiola 2022
 */

package com.yournote.search.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import com.yournote.search.SearchScreen
import com.yournote.search.SearchViewModel
import com.yournote.ui.FirebaseScreenLog

fun NavBackStack.navigateToSearch() {
    add(Search)
}

@OptIn(ExperimentalSharedTransitionApi::class)
fun EntryProviderBuilder<NavKey>.search(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    navigateToDetail: (Long, Int, Int) -> Unit = { _, _, _ -> },

) {
    entry<Search> {
        FirebaseScreenLog(screen = "main_screen")
        val searchViewModel: SearchViewModel = hiltViewModel()
        val searchState = searchViewModel.searchState.collectAsStateWithLifecycle()

        SearchScreen(
            modifier = modifier,
            searchState = searchState.value,
            searchQuery = searchViewModel.searchQuery,
            onBack = onBack,
            onSetSearch = searchViewModel::onSetSearch,
            onNoteClick = navigateToDetail,

        )
    }
}
