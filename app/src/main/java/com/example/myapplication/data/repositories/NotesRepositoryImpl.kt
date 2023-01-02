package com.example.myapplication.data.repositories

import Note
import com.example.myapplication.data.datasources.NotesDao
import com.example.myapplication.domain.repositories.NotesRepository
import kotlinx.coroutines.flow.Flow


class NotesRepositoryImpl(
    private val notesDao: NotesDao
) : NotesRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return notesDao.getAllNotes()
    }

    override suspend fun getNoteById(id: Int): Note {
        return notesDao.getNoteById(id)
    }

    override suspend fun save(note: Note) {
        return notesDao.insert(note)
    }

    override suspend fun update(noteId: Int, note: Note) {
        return notesDao.update(noteId, note)
    }

    override suspend fun delete(noteId: Int) {
        // First we get the note to delete
        val note = notesDao.getNoteById(noteId)
        // Then we delete it
        return notesDao.delete(note)
    }
}
