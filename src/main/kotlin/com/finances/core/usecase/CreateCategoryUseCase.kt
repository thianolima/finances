package com.finances.core.usecase

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.port.input.CategoryPort
import com.finances.core.model.Category

class CreateCategoryUseCase(private val categoryPort : CategoryPort) {
    private val MSG_EXISTS = "Nome de categoria já utilizada no sistema!"
    fun execute(category: Category) =
        when(categoryPort.existsByName(category.name)) {
            true -> throw EntityAlreadyExistsException(MSG_EXISTS)
            false -> categoryPort.save(category)
        }
}