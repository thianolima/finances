package com.finances.infrastructure.configuration.app

import com.finances.core.usecase.expense.CreateExpenseUseCase
import com.finances.infrastructure.dataprovider.adapter.ExpenseDatabaseAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ExpenseConfiguration {
    @Bean
    fun createExpenseUseCase(expenseDatabaseAdapter: ExpenseDatabaseAdapter) =
        CreateExpenseUseCase(expenseDatabaseAdapter)
}