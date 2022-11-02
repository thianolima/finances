package com.finances.core.usecase

import com.finances.core.exception.DomainException
import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.gateway.CategoryGateway
import com.finances.core.model.Category
import com.finances.dataprovider.entity.toCategoryEntity

class SaveCategoryUseCaseImpl(private val categoryGateway : CategoryGateway) : SaveCategoryUseCase {
    private val MSG_EXISTS_CATEGORY = "Nome de categoria já utilizada no sistema!"
    override fun execute(category: Category) =
        when(categoryGateway.existsByName(category.name)) {
            true -> throw EntityAlreadyExistsException(MSG_EXISTS_CATEGORY)
            false -> categoryGateway.save(category)
        }
}