package com.finances.core.usecase.category

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.model.Category
import com.finances.core.port.input.CategoryPort

class CreateCategoryUseCase(private val categoryPort: CategoryPort) {

    private val MSG_EXISTS = "Nome de Categoria já utilizada no sistema!"

    fun execute(category: Category) =
        when (categoryPort.existsByName(category.name)) {
            true -> throw EntityAlreadyExistsException(MSG_EXISTS)
            false -> categoryPort.save(category)
        }
}