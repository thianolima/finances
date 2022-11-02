package com.finances.core.usecase

import com.finances.core.gateway.CategoryGateway
import com.finances.core.model.Category

class SaveCategoryUseCaseImpl(private val categoryGateway : CategoryGateway) : SaveCategoryUseCase {
    override fun execute(category: Category) {
        categoryGateway.save(category);
    }
}