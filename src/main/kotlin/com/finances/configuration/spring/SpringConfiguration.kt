package com.finances.configuration.spring

import com.finances.dataprovider.service.CategoryService
import com.finances.core.usecase.CreateCategoryUseCase
import com.finances.core.usecase.DeleteCategoryUseCase
import com.finances.core.usecase.UpdateCategoryUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfiguration {
    @Bean
    fun createCategoryUseCase(categoryService : CategoryService) = CreateCategoryUseCase(categoryService)
    @Bean
    fun deleteCategoryUseCase(categoryService : CategoryService) = DeleteCategoryUseCase(categoryService)
    @Bean
    fun updateCategoryUseCase(categoryService : CategoryService) = UpdateCategoryUseCase(categoryService)
}