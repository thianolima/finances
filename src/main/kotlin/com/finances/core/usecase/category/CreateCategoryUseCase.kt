package com.finances.core.usecase.category

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.model.Category
import com.finances.core.port.CategoryDatabasePort

class CreateCategoryUseCase(private val categoryDatabasePort: CategoryDatabasePort) {

    private val MSG_EXISTS = "Nome de Categoria já utilizada no sistema!"

    fun execute(category: Category) =
        when (categoryDatabasePort.existsByName(category.name)) {
            true -> throw EntityAlreadyExistsException(MSG_EXISTS)
            false -> categoryDatabasePort.save(category)
        }
}