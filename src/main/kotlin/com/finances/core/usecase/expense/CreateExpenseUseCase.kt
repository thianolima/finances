package com.finances.core.usecase.expense

import com.finances.core.model.Expense
import com.finances.core.repository.ExpenseRepository

class CreateExpenseUseCase (private val expenseRepository: ExpenseRepository){

    fun execute(expense: Expense) =
        expenseRepository.save(expense)
}