package com.finances.infrastructure.configuration.app

import com.finances.core.usecase.expense.CreateExpenseUseCase
import com.finances.core.usecase.expense.GetExpenseByIdUseCase
import com.finances.core.usecase.expense.UpdateExpenseUseCase
import com.finances.infrastructure.dataprovider.database.adapter.ExpenseDatabaseAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ExpenseConfiguration {
    @Bean
    fun createExpenseUseCase(expenseDatabaseAdapter: ExpenseDatabaseAdapter) =
        CreateExpenseUseCase(expenseDatabaseAdapter)

    @Bean
    fun getExpenseByIdUseCase(expenseDatabaseAdapter: ExpenseDatabaseAdapter) =
        GetExpenseByIdUseCase(expenseDatabaseAdapter)

    @Bean
    fun updateExpenseUseCase(expenseDatabaseAdapter: ExpenseDatabaseAdapter) =
        UpdateExpenseUseCase(expenseDatabaseAdapter)
}