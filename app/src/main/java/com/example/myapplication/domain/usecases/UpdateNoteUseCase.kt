package com.example.myapplication.domain.usecases

import Note
import com.example.myapplication.domain.repositories.NotesRepository
import com.example.myapplication.domain.util.UseCase

class UpdateNoteUseCase(
    private val notesRepository: NotesRepository
) : UseCase<UpdateNoteUseCaseParams, Unit>() {
    /**
     * Updates a note in the system.
     * @param params the note to be updated.
     */
    override suspend operator fun invoke(params: UpdateNoteUseCaseParams) {
        return notesRepository.update(params.noteId,params.note)

    }
}

sealed class UpdateNoteUseCaseParams(
    val noteId: Int,
    val note: Note
)