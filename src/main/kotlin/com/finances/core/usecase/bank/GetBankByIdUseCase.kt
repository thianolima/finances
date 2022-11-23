package com.finances.core.usecase.bank

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.port.input.BankPort
import com.finances.core.port.input.CategoryPort

class GetBankByIdUseCase(private val bankPort: BankPort) {

    private val MSG_NOT_FOUND = "Banco não encontrado!"

    fun execute(id: String) =
        bankPort.findById(id)
            .orElseThrow { EntityNotFoundException(MSG_NOT_FOUND) }
}
