/*
 *abiola 2022
 */

package com.yournote.notepad

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.play.core.review.ReviewManagerFactory
import com.yournote.common.IContentManager
import com.yournote.data.repository.LabelRepository
import com.yournote.data.repository.UserDataRepository
import com.yournote.domain.AddAllNoteUseCase
import com.yournote.model.Note
import com.yournote.model.NoteCheck
import com.yournote.model.NoteDisplayCategory
import com.yournote.model.NoteImage
import com.yournote.model.NotePad
import com.yournote.model.NoteVoice
import com.yournote.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository,
    private val labelRepository: LabelRepository,
    private val addNoteUseCase: AddAllNoteUseCase,
    private val contentManager: IContentManager,

) : ViewModel() {

    private var noteCount = 0

    fun triggerInAppReviewIfNeeded(activity: Activity) {
        noteCount++
        if (noteCount == 3) {
            try {
                val manager = ReviewManagerFactory.create(activity)
                val request = manager.requestReviewFlow()
                request.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        manager.launchReviewFlow(activity, task.result)
                    }
                }
            } catch (_: Exception) {
                // Review not available, silently ignore
            }
        }
    }
    val uiState: StateFlow<MainActivityUiState> = userDataRepository
        .userData.map {
            MainActivityUiState.Success(it)
        }.stateIn(
            scope = viewModelScope,
            initialValue = MainActivityUiState.Loading,
            started = SharingStarted.WhileSubscribed(),
        )

    val labels = labelRepository
        .getAll().stateIn(
            scope = viewModelScope,
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5_000),
        )

    suspend fun insertNewNote(): Long {
        return addNoteUseCase(NotePad())
    }

    suspend fun insertNewAudioNote(uri: String, text: String): Long {
        val id = contentManager.saveVoice(uri)

        val voice = NoteVoice(
            id = id,
        )

        val notePad = NotePad(
            note = Note(detail = text),
            voices = listOf(voice),
        )
        return addNoteUseCase(notePad)
    }

    suspend fun insertNewImageNote(uri: String): Long {
        val id = contentManager.saveImage(uri)

        val image = NoteImage(
            id = id,
        )

        val notePad = NotePad(
            images = listOf(image),
        )
        return addNoteUseCase(notePad)
    }
    suspend fun insertNewDrawing(): Long {
        val notePad = NotePad()

        val noteId = addNoteUseCase(notePad)

        return noteId
    }
    suspend fun insertNewCheckNote(): Long {
        val notePad = NotePad(
            note = Note(isCheck = true),
            checks = listOf(NoteCheck()),
        )
        return addNoteUseCase(notePad)
    }

    fun pictureUri(): String {
        return contentManager.pictureUri()
    }

    fun setMainData(noteDisplayCategory: NoteDisplayCategory) {
        viewModelScope.launch {
            userDataRepository.setNoteDisplayCategory(noteDisplayCategory)
        }
    }
}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val userData: UserData) : MainActivityUiState
}
