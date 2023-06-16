package com.finances.infrastructure.configuration.app

import com.finances.core.usecase.category.CreateCategoryUseCase
import com.finances.core.usecase.category.DeleteCategoryUseCase
import com.finances.core.usecase.category.FindCategoryByIdUseCase
import com.finances.core.usecase.category.UpdateCategoryUseCase
import com.finances.infrastructure.dataprovider.database.repository.CategoryRepositoryJPA
import com.finances.infrastructure.dataprovider.database.repository.ExpenseRepositoryJPA
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CategoryConfiguration {
    @Bean
    fun createCategoryUseCase(categoryRepository: CategoryRepositoryJPA) =
        CreateCategoryUseCase(categoryRepository)

    @Bean
    fun deleteCategoryUseCase(categoryRepository: CategoryRepositoryJPA, expenseRepository: ExpenseRepositoryJPA) =
        DeleteCategoryUseCase(categoryRepository, expenseRepository)

    @Bean
    fun updateCategoryUseCase(categoryRepository: CategoryRepositoryJPA) =
        UpdateCategoryUseCase(categoryRepository)

    @Bean
    fun getCategoryByIdUseCase(categoryRepository: CategoryRepositoryJPA) =
        FindCategoryByIdUseCase(categoryRepository)
}