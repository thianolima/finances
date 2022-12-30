package com.finances.core.usecase.category

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.exception.EntityNotFoundException
import com.finances.core.model.Category
import com.finances.core.repository.CategoryRepository

class UpdateCategoryUseCase(private val categoryRepository: CategoryRepository) {
    private val MSG_EXISTS = "Nome de categoria já utilizada no sistema!"
    private val MSG_NOT_FOUND = "Categoria não encontrada!"

    fun execute(category: Category) =
        when (validate(category)) {
            true -> categoryRepository.save(category)
            false -> throw EntityAlreadyExistsException(MSG_EXISTS)
        }

    private fun validate(category: Category) =
        when (categoryRepository.findById(category.id).isPresent) {
            true -> !categoryRepository.existsByName(category.name)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}