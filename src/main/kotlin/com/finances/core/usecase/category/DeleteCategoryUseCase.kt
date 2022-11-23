package com.finances.core.usecase.category

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.port.CategoryDatabasePort

class DeleteCategoryUseCase(private val categoryDatabasePort: CategoryDatabasePort) {

    private val MSG_NOT_FOUND = "Categoria não encontrada!"

    fun execute(id: String) =
        when(categoryDatabasePort.findById(id).isPresent){
            true -> categoryDatabasePort.delete(id)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}