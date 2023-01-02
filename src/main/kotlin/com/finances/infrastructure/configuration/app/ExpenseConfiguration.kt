package com.finances.infrastructure.configuration.app

import com.finances.core.usecase.expense.CreateExpenseUseCase
import com.finances.core.usecase.expense.GetExpenseByIdUseCase
import com.finances.core.usecase.expense.UpdateExpenseUseCase
import com.finances.infrastructure.dataprovider.database.repository.ExpenseRepositoryJPA
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ExpenseConfiguration {
    @Bean
    fun createExpenseUseCase(expenseRepository: ExpenseRepositoryJPA) =
        CreateExpenseUseCase(expenseRepository)

    @Bean
    fun getExpenseByIdUseCase(expenseRepository: ExpenseRepositoryJPA) =
        GetExpenseByIdUseCase(expenseRepository)

    @Bean
    fun updateExpenseUseCase(expenseRepository: ExpenseRepositoryJPA) =
        UpdateExpenseUseCase(expenseRepository)
}