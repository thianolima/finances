package com.finances.core.usecase.category

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.model.Category
import com.finances.core.repository.CategoryRepository

class CreateCategoryUseCase(
    val categoryRepository: CategoryRepository
) {
    val MSG_EXISTS = "Nome de Categoria já utilizada no sistema!"

    fun execute(category: Category) =
        when (categoryRepository.existsByName(category.name)) {
            true -> throw EntityAlreadyExistsException(MSG_EXISTS)
            false -> categoryRepository.save(category)
        }
}