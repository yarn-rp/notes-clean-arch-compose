package com.example.myapplication.domain.repositories

import Note
import kotlinx.coroutines.flow.Flow

/**
 * Repository for the notes. This is the single source of truth for the notes.
 * @see Note
 */
interface NotesRepository {
    /**
     * Exposes a stream type with all the notes of the database.
     * Every time a note is inserted, updated or deleted, the stream will emit a new value.
     *
     * @return A [Flow] of all the notes of the database.
     */
    fun getAllNotes(): Flow<List<Note>>
    /**
     * Gets a note by id.
     * @return the note with the given id.
     * @param id the id of the note.
     * @throws IllegalArgumentException if note with given [id] doesn't exist.
     */
    suspend fun getNoteById(id: Int): Note
    /**
     * Saves the note in system.
     * @param note the note to be inserted.
     */
    suspend fun save(note: Note)
    /**
     * Updates a note in the system.
     * @param [noteId] the id of the note to be updated.
     * @param [note] the note to be updated.
     * @throws IllegalArgumentException if note with given [noteId] doesn't exist.
     */
    suspend fun update(noteId: Int, note: Note)
    /**
     * Deletes a note  with the given [noteId].
     * @param noteId the id of the note to be deleted.
     * @throws IllegalArgumentException if note with given [noteId] doesn't exist.
     */
    suspend fun delete(noteId: Int)
}