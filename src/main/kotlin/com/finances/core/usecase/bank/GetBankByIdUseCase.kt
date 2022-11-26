package com.finances.core.usecase.bank

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.port.BankDatabasePort

class GetBankByIdUseCase(private val bankDatabasePort: BankDatabasePort) {
    private val MSG_NOT_FOUND = "Banco não encontrado!"

    fun execute(id: String) =
        bankDatabasePort.findById(id)
            .orElseThrow { EntityNotFoundException(MSG_NOT_FOUND) }
}
