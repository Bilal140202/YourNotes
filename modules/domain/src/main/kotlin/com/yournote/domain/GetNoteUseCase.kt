package com.yournote.domain

import com.yournote.common.IContentManager
import com.yournote.data.repository.NoteRepository
import com.yournote.model.NotePad
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class GetNoteUseCase
@Inject constructor(
    private val noteRepository: NoteRepository,
    private val linkUriUseCase: LinkUriUseCase,
    private val contentManager: IContentManager,

) {
    operator fun invoke(id: Long): Flow<NotePad?> {
        return noteRepository.get(id)
            .mapLatest {
                it?.copy(
                    images = it.images.map { image ->
                        image.copy(path = contentManager.getImagePath(image.id))
                    },
                    uris = linkUriUseCase(it.note.detail, 10),
                    voices = it.voices.map { voice ->
                        val path = contentManager.getVoicePath(voice.id)
                        voice.copy(
                            path = path,
                            length = contentManager.getAudioLength(path),
                        )
                    },
                )
            }
    }
}
