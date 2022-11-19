package com.finances.core.usecase

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.port.input.CategoryPort

class GetCategoryByIdUseCase(private val categoryPort: CategoryPort) {

    private val MSG_NOT_FOUND = "Categoria não encontrada!"

    fun execute(id: String) =
        categoryPort.findById(id)
            .orElseThrow { EntityNotFoundException(MSG_NOT_FOUND) }
}
