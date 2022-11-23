package com.finances.core.usecase.category

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.exception.EntityNotFoundException
import com.finances.core.model.Category
import com.finances.core.port.CategoryDatabasePort

class UpdateCategoryUseCase(private val categoryDatabasePort: CategoryDatabasePort) {
    private val MSG_EXISTS = "Nome de categoria já utilizada no sistema!"
    private val MSG_NOT_FOUND = "Categoria não encontrada!"

    fun execute(category: Category) =
        when (validate(category)) {
            true -> categoryDatabasePort.save(category)
            false -> throw EntityAlreadyExistsException(MSG_EXISTS)
        }

    private fun validate(category: Category) =
        when (categoryDatabasePort.findById(category.id).isPresent) {
            true -> !categoryDatabasePort.existsByName(category.name)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}