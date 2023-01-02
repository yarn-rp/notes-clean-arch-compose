package com.example.myapplication.data.datasources

import Note
import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Database for the notes app.
 * @see Note
 */
@Database(entities = [Note::class], version =1)
abstract class NotesDatabase : RoomDatabase() {
    /**
     * Exposes the notes data access object.
     * @see NotesDao
     */
    abstract fun notesDao(): NotesDao
}