package com.finances.configuration.spring

import com.finances.dataprovider.service.CategoryService
import com.finances.core.usecase.SaveCategoryUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfiguration {
    @Bean
    fun saveCategoryUseCase(categoryService : CategoryService) = SaveCategoryUseCaseImpl(categoryService)

/*    @Bean
    fun categoryService(categoryRepository: CategoryRepository) = CategoryService(categoryRepository)*/
}