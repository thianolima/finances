package com.finances.core.usecase.expense

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.repository.ExpenseRepository
import java.time.LocalDate

class GetExpenseByBuyDateAndAmountUseCase(private val expenseRepository: ExpenseRepository) {
    private val MSG_NOT_FOUND = "Despesa não encontrado!"

    fun execute(buyDate: LocalDate, amount: Double) =
        expenseRepository.findByBuyDateAndAmount(buyDate, amount)
            .orElseThrow { EntityNotFoundException(MSG_NOT_FOUND) }

}