package com.example.myapplication.domain.usecases

import Note
import com.example.myapplication.domain.repositories.NotesRepository
import com.example.myapplication.domain.util.UseCase

class SaveNoteUseCase(
    private val notesRepository: NotesRepository
): UseCase<SaveNoteUseCaseParams, Unit>() {
    /**
     * Saves a note in the system.
     * @param params the note to be saved.
     */
    override suspend operator fun invoke(params: SaveNoteUseCaseParams) {
       return notesRepository.save(params.note)
    }
}

sealed class SaveNoteUseCaseParams(
    val note: Note
)