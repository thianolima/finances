package com.finances.core.usecase.category

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.port.CategoryDatabasePort

class GetCategoryByIdUseCase(private val categoryDatabasePort: CategoryDatabasePort) {

    private val MSG_NOT_FOUND = "Categoria não encontrada!"

    fun execute(id: String) =
        categoryDatabasePort.findById(id)
            .orElseThrow { EntityNotFoundException(MSG_NOT_FOUND) }
}
