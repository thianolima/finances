package com.finances.core.usecase.expense

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.repository.ExpenseRepository

class FindExpenseByIdUseCase(
    val expenseRepository: ExpenseRepository
) {
    val MSG_NOT_FOUND = "Despesa não encontrado!"

    fun execute(id: String) =
        expenseRepository.findById(id)
            .orElseThrow { EntityNotFoundException(MSG_NOT_FOUND) }
}