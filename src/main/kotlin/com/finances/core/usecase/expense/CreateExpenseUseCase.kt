package com.finances.core.usecase.expense

import com.finances.core.model.Expense
import com.finances.core.port.ExpenseDatabasePort

class CreateExpenseUseCase (private val expenseDatabasePort: ExpenseDatabasePort){

    fun execute(expense: Expense) =
        expenseDatabasePort.save(expense)
}