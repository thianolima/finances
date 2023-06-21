package com.finances.core.usecase.expense

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.model.Expense
import com.finances.core.repository.ExpenseRepository

class UpdateExpenseUseCase(
    val expenseRepository: ExpenseRepository
){
    private val MSG_NOT_FOUND = "Despesa não encontrada!"

    fun execute(expense: Expense) =
        when (expenseRepository.findById(expense.id).isPresent) {
            true -> expenseRepository.save(expense)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}