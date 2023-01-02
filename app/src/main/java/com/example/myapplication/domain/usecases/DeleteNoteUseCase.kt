package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.repositories.NotesRepository
import com.example.myapplication.domain.util.UseCase

class DeleteNoteUseCase(
    private val notesRepository: NotesRepository
) : UseCase<DeleteNoteUseCaseParams, Unit>() {
    /**
     * Deletes a note from the system.
     * @param params the id of the note to be deleted.
     */
    override suspend operator fun invoke(params: DeleteNoteUseCaseParams) {
        return notesRepository.delete(params.id)
    }
}

sealed class DeleteNoteUseCaseParams(
    val id: Int
)