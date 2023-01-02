package com.example.myapplication.domain.usecases

import Note
import com.example.myapplication.domain.repositories.NotesRepository
import com.example.myapplication.domain.util.UseCase

class GetNoteByIdUse(
    private val notesRepository: NotesRepository
) : UseCase<GetNotesByIdUseCaseParams, Note>() {
    /**
     * Gets a note by its id.
     * @param params the id of the note.
     * @return the note with the given id.
     * @throws IllegalArgumentException if note with given id doesn't exist.
     */
    override suspend operator fun invoke(params:  GetNotesByIdUseCaseParams): Note {
        return notesRepository.getNoteById(params.id)
    }
}

sealed class GetNotesByIdUseCaseParams(
    val id: Int
)