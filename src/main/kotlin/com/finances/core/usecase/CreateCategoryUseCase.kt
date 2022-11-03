package com.finances.core.usecase

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.gateway.CategoryGateway
import com.finances.core.model.Category

class CreateCategoryUseCase(private val categoryGateway : CategoryGateway) {
    private val MSG_EXISTS = "Nome de categoria já utilizada no sistema!"
    fun execute(category: Category) =
        when(categoryGateway.existsByName(category.name)) {
            true -> throw EntityAlreadyExistsException(MSG_EXISTS)
            false -> categoryGateway.save(category)
        }
}