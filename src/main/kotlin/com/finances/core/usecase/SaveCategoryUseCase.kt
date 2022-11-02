package com.finances.core.usecase

import com.finances.core.model.Category

interface SaveCategoryUseCase {
    fun execute(category: Category)
}