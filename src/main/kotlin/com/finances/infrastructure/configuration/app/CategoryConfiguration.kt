package com.finances.infrastructure.configuration.app

import com.finances.core.usecase.category.CreateCategoryUseCase
import com.finances.core.usecase.category.DeleteCategoryUseCase
import com.finances.core.usecase.category.GetCategoryByIdUseCase
import com.finances.core.usecase.category.UpdateCategoryUseCase
import com.finances.infrastructure.dataprovider.adapter.CategoryDatabaseAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CategoryConfiguration {
    @Bean
    fun createCategoryUseCase(categoryDatabaseAdapter: CategoryDatabaseAdapter) =
        CreateCategoryUseCase(categoryDatabaseAdapter)

    @Bean
    fun deleteCategoryUseCase(categoryDatabaseAdapter: CategoryDatabaseAdapter) =
        DeleteCategoryUseCase(categoryDatabaseAdapter)

    @Bean
    fun updateCategoryUseCase(categoryDatabaseAdapter: CategoryDatabaseAdapter) =
        UpdateCategoryUseCase(categoryDatabaseAdapter)

    @Bean
    fun getCategoryByIdUseCase(categoryDatabaseAdapter: CategoryDatabaseAdapter) =
        GetCategoryByIdUseCase(categoryDatabaseAdapter)
}