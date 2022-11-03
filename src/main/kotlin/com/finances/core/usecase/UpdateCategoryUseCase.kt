package com.finances.core.usecase

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.exception.EntityNotFoundException
import com.finances.core.gateway.CategoryGateway
import com.finances.core.model.Category

class UpdateCategoryUseCase(private val categoryGateway : CategoryGateway) {
    private val MSG_EXISTS = "Nome de categoria já utilizada no sistema!"
    private val MSG_NOT_FOUND = "Categoria não encontrada!"

    fun execute(category : Category) =
        when(validate(category)) {
            true -> categoryGateway.save(category)
            false -> throw EntityAlreadyExistsException(MSG_EXISTS)
        }

    private fun validate(category: Category) : Boolean =
        when (categoryGateway.findById(category.id).isPresent) {
            true -> !categoryGateway.existsByName(category.name)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}