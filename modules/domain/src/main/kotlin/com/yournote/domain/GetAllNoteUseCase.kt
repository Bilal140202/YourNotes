package com.yournote.domain

import com.yournote.common.IContentManager
import com.yournote.data.repository.NoteRepository
import com.yournote.model.NoteDisplayCategory
import com.yournote.model.NotePad
import com.yournote.model.NoteType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllNoteUseCase
@Inject constructor(
    private val noteRepository: NoteRepository,
    private val linkUriUseCase: LinkUriUseCase,
    private val contentManager: IContentManager,

) {
    operator fun invoke(noteDisplayCategory: NoteDisplayCategory): Flow<List<NotePad>> {
        val notes = when (noteDisplayCategory.noteType) {
            NoteType.LABEL ->
                noteRepository
                    .getAll()
                    .map { notes ->
                        notes.filter { note ->
                            note.labels.any { it.id == noteDisplayCategory.labelId }
                        }
                    }

            NoteType.REMINDER ->
                noteRepository
                    .getAll()
                    .map { notes ->
                        notes.filter { note ->
                            note.notification != null
                        }
                    }

            else -> noteRepository.getByNoteType(noteDisplayCategory.noteType)
        }

        return notes
            .map { notes ->
                notes.map { note ->
                    note.copy(
                        images = note.images.map { image ->
                            image.copy(path = contentManager.getImagePath(image.id))
                        },
                        uris = linkUriUseCase(
                            note.note.detail,
                            10,
                        ),
//                        voices = note.voices.map { voice ->
//                            val path = contentManager.getVoicePath(voice.id)
//                            voice.copy(
//                                voiceName = path,
//                            )
//                        },
                    )
                }
            }
    }
}
