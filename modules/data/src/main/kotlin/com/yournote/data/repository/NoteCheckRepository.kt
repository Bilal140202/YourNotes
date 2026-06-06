package com.yournote.data.repository

import com.yournote.model.NoteCheck
import kotlinx.coroutines.flow.Flow

interface NoteCheckRepository {

    suspend fun upserts(checks: List<NoteCheck>): List<Long>

    suspend fun upsert(check: NoteCheck): Long
    suspend fun delete(id: Long)

    suspend fun deleteCheckedItems(noteId: Long)

    suspend fun deleteByNoteId(noteId: Long)

    fun getAll(): Flow<List<NoteCheck>>
    fun getByNoteId(noteId: Long): Flow<List<NoteCheck>>

    fun get(id: Long): Flow<NoteCheck?>
}
