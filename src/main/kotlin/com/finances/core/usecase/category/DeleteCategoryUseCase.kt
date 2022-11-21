package com.finances.core.usecase.category

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.port.input.CategoryPort

class DeleteCategoryUseCase(private val categoryPort: CategoryPort) {

    private val MSG_NOT_FOUND = "Categoria não encontrada!"

    fun execute(id: String) =
        when(categoryPort.findById(id).isPresent){
            true -> categoryPort.delete(id)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}