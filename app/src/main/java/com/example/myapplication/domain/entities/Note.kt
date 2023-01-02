package com.example.myapplication.domain.entities

import androidx.room.Entity

@Entity(tableName = "notes")
data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val color: Int,
    val timestamp: Long
)
