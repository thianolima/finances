package com.finances.infrastructure.configuration.app

import com.finances.core.usecase.category.CreateCategoryUseCase
import com.finances.core.usecase.category.DeleteCategoryUseCase
import com.finances.core.usecase.category.GetCategoryByIdUseCase
import com.finances.core.usecase.category.UpdateCategoryUseCase
import com.finances.infrastructure.dataprovider.service.CategoryService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CategoryConfiguration {
    @Bean
    fun createCategoryUseCase(categoryService: CategoryService) =
        CreateCategoryUseCase(categoryService)

    @Bean
    fun deleteCategoryUseCase(categoryService: CategoryService) =
        DeleteCategoryUseCase(categoryService)

    @Bean
    fun updateCategoryUseCase(categoryService: CategoryService) =
        UpdateCategoryUseCase(categoryService)

    @Bean
    fun getCategoryByIdUseCase(categoryService: CategoryService) =
        GetCategoryByIdUseCase(categoryService)
}