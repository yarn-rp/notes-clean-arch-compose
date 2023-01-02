package com.example.myapplication.data.datasources

import Note
import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Data access object for the notes table.
 * @see Note
 * [getNotes]() returns a Flow<List<Note>>. This means that whenever the notes table is updated,
 */
@Dao
interface NotesDao {
    /**
     * Exposes and stream type with all the notes of the database.
     * Every time a note is inserted, updated or deleted, the stream will emit a new value.
     *
     * @return A stream of all the notes of the database.
     */
    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<Note>>

    /**
     * Gets a note by id.
     * @return the note with the given id.
     * @param id the id of the note.
     * @throws IllegalArgumentException if note with given [id] doesn't exist.
     */
    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: Int): Note
    /**
     * Inserts a note into the database.
     * @param note the note to be inserted.
     * @return the id of the inserted note.
     */

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(note: Note)
    /**
     * Updates a note in the database.
     * @param note the note to be updated.
     * @throws IllegalArgumentException if note with given [id] doesn't exist.
     */
    @Update
    suspend fun update(id: Int, note: Note)

    /**
     * Deletes a note from the database.
     * @param note the note to be deleted.
     * @throws IllegalArgumentException if note with given [id] doesn't exist.
     */
    @Delete
    fun delete(note: Note)
}