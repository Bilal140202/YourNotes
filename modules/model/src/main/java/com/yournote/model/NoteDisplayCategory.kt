package com.yournote.model

import kotlinx.serialization.Serializable

@Serializable
data class NoteDisplayCategory(
    val labelId: Long = 1,
    val noteType: NoteType = NoteType.NOTE,
)
