package com.yournote.data.repository

import com.yournote.common.network.Dispatcher
import com.yournote.common.network.NoteDispatchers
import com.yournote.data.model.asEntity
import com.yournote.data.model.toNotePad
import com.yournote.database.dao.NoteDao
import com.yournote.model.NotePad
import com.yournote.model.NoteType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class RealNoteRepository
@Inject constructor(
    private val noteDao: NoteDao,
    @Dispatcher(NoteDispatchers.IO)
    private val dispatcher: CoroutineDispatcher,
) : NoteRepository {
    override suspend fun upserts(notes: List<NotePad>): List<Long> {
        return withContext(dispatcher) {
            noteDao.upserts(notes.map { it.note.asEntity() })
        }
    }

    override suspend fun upsert(note: NotePad): Long {
        return withContext(dispatcher) {
            noteDao.upsert(note.note.asEntity())
        }
    }

    override suspend fun delete(id: Long) {
        withContext(dispatcher) {
            noteDao.delete(id)
        }
    }

    override suspend fun deleteIds(ids: Set<Long>) {
        withContext(dispatcher) {
            noteDao.deleteIds(ids)
        }
    }

    override suspend fun deleteTrash() {
        withContext(dispatcher) {
            noteDao.deleteTrash(NoteType.TRASH)
        }
    }

    override fun getAll(): Flow<List<NotePad>> {
        return noteDao.getAll()
            .map { list -> list.map { it.toNotePad() } }
    }

    override fun get(id: Long): Flow<NotePad?> {
        return noteDao.get(id)
            .map { it?.toNotePad() }
    }

    override fun getByNoteType(noteType: NoteType): Flow<List<NotePad>> {
        return noteDao.getByNoteType(noteType)
            .map { list -> list.map { it.toNotePad() } }
    }

    override fun getByNoteIds(set: Set<Long>): Flow<List<NotePad>> {
        return noteDao.getByIds(set)
            .map { list -> list.map { it.toNotePad() } }
    }
}
