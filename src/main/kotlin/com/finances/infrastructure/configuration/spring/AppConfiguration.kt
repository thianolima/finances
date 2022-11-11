package com.finances.infrastructure.configuration.spring

import com.finances.infrastructure.dataprovider.service.CategoryService
import com.finances.core.usecase.CreateCategoryUseCase
import com.finances.core.usecase.DeleteCategoryUseCase
import com.finances.core.usecase.GetCategoryByIdUseCase
import com.finances.core.usecase.UpdateCategoryUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfiguration {
    @Bean
    fun createCategoryUseCase(categoryService : CategoryService) = CreateCategoryUseCase(categoryService)
    @Bean
    fun deleteCategoryUseCase(categoryService : CategoryService) = DeleteCategoryUseCase(categoryService)
    @Bean
    fun updateCategoryUseCase(categoryService : CategoryService) = UpdateCategoryUseCase(categoryService)
    @Bean
    fun getCategoryByIdUseCase(categoryService : CategoryService) = GetCategoryByIdUseCase(categoryService)
}