package com.example.myapplication.domain.usecases

import Note
import com.example.myapplication.domain.repositories.NotesRepository
import com.example.myapplication.domain.util.OrderType
import com.example.myapplication.domain.util.SortBy
import com.example.myapplication.domain.util.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllNotesUseCase(
    private val notesRepository: NotesRepository
)
: UseCase<GetAllNotesUseCaseParams, Flow<List<Note>>>() {
    /**
     * Gets all the notes.
     * @return a [Flow] of all the notes.
     */
    override suspend operator fun invoke(params: GetAllNotesUseCaseParams): Flow<List<Note>> {
        // Get the flow data
        val notesFlow = notesRepository.getAllNotes()
        // Sort by function depending on the params
        val sortBy = { notes: List<Note> -> orderNotesBy(notes, params.sortBy)}
        return notesFlow.map(sortBy)
    }
}

sealed class GetAllNotesUseCaseParams(val sortBy : SortBy)

private fun orderNotesBy(notes: List<Note>, sortBy: SortBy) : List<Note> {
    return when(sortBy.orderType) {
        is OrderType.Ascending -> {
            sortNotesBy(notes, sortBy)
        }
        is OrderType.Descending -> {
            sortNotesDescendingBy(notes, sortBy).reversed()
        }
    }
}

private fun sortNotesBy(notes: List<Note>, sortBy: SortBy) : List<Note> {
    return when(sortBy) {
        is SortBy.Date -> notes.sortedBy { it.timestamp.toString() }
        is SortBy.Title -> notes.sortedBy { it.title }
    }
}
private fun sortNotesDescendingBy(notes: List<Note>, sortBy: SortBy) : List<Note> {
    return when(sortBy) {
        is SortBy.Date -> notes.sortedByDescending { it.timestamp.toString() }
        is SortBy.Title -> notes.sortedByDescending { it.title }
    }
}
