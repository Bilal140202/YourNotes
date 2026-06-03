package com.yournote.domain

import com.yournote.data.repository.NoteCheckRepository
import com.yournote.data.repository.NoteDrawingRepository
import com.yournote.data.repository.NoteImageRepository
import com.yournote.data.repository.NoteLabelRepository
import com.yournote.data.repository.NoteNotificationRepository
import com.yournote.data.repository.NoteRepository
import com.yournote.data.repository.NoteVoiceRepository
import com.yournote.model.NoteLabel
import com.yournote.model.NotePad
import javax.inject.Inject
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class AddAllNoteUseCase
@Inject constructor(
    private val noteRepository: NoteRepository,
    private val noteCheckRepository: NoteCheckRepository,
    private val noteDrawingRepository: NoteDrawingRepository,
    private val noteImageRepository: NoteImageRepository,
    private val noteLabelRepository: NoteLabelRepository,
    private val noteNotificationRepository: NoteNotificationRepository,
    private val noteVoiceRepository: NoteVoiceRepository,

) {
    @OptIn(ExperimentalTime::class)
    suspend operator fun invoke(notePad: NotePad): Long {
//        check(!notePad.isEmpty())

        val now = Clock.System.now().toEpochMilliseconds()

        var id = noteRepository.upsert(notePad.copy(note = notePad.note.copy(editDate = now)))

        if (id == -1L) {
            id = notePad.note.id
        }
        if (notePad.voices.isNotEmpty()) {
            noteVoiceRepository.upserts(
                notePad.voices.map { it.copy(noteId = id) },
            )
        }

        if (notePad.drawings.isNotEmpty()) {
            noteDrawingRepository.upserts(
                notePad.drawings.map { it.copy(noteId = id) },
            )
        }
        if (notePad.images.isNotEmpty()) {
            noteImageRepository.upserts(
                notePad.images.map { it.copy(noteId = id) },
            )
        }
        if (notePad.checks.isNotEmpty()) {
            noteCheckRepository.upserts(
                notePad.checks.map { it.copy(noteId = id) },
            )
        }
        if (notePad.labels.isNotEmpty()) {
            noteLabelRepository.upserts(
                notePad.labels.map { NoteLabel(noteId = id, labelId = it.id) },
            )
        }
        if (notePad.notification != null) {
            noteNotificationRepository.upsert(
                notePad.notification!!.copy(noteId = id),
            )
        }

        return id
    }
}
