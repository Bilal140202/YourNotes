package com.yournote.gallery

import com.yournote.model.NoteImage

data class GalleryUiState(
    val images: List<NoteImage> = emptyList(),
    val initIndex: Int = 0,
)
