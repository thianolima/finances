package com.finances.core.usecase.expense

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.model.Expense
import com.finances.core.port.ExpenseDatabasePort

class UpdateExpenseUseCase (private val expenseDatabasePort: ExpenseDatabasePort){

    private val MSG_NOT_FOUND = "Despesa não encontrada!"

    fun execute(expense: Expense) =
        when (expenseDatabasePort.findById(expense.id).isPresent) {
            true -> expenseDatabasePort.save(expense)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}