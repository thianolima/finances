package com.finances.core.usecase.expense

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.port.ExpenseDatabasePort

class GetExpenseByIdUseCase(private val expenseDatabasePort: ExpenseDatabasePort) {
    private val MSG_NOT_FOUND = "Despesa não encontrado!"

    fun execute(id: String) =
        expenseDatabasePort.findById(id)
            .orElseThrow { EntityNotFoundException(MSG_NOT_FOUND) }
}