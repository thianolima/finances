package com.finances.core.usecase.expense

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.repository.ExpenseRepository

class FindLastCategoryByExpenseDescriptionUseCase(
    val expenseRepository: ExpenseRepository
) {
    val MSG_NOT_FOUND = "Despesa não encontrado!"

    fun execute(description: String) =
        expenseRepository.findLastCategoryByDescription(description)
            .orElseThrow { EntityNotFoundException(MSG_NOT_FOUND) }
}