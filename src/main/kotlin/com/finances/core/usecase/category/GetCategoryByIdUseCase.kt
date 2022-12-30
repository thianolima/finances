package com.finances.core.usecase.category

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.repository.CategoryRepository

class GetCategoryByIdUseCase(private val categoryRepository: CategoryRepository) {

    private val MSG_NOT_FOUND = "Categoria não encontrada!"

    fun execute(id: String) =
        categoryRepository.findById(id)
            .orElseThrow { EntityNotFoundException(MSG_NOT_FOUND) }
}
