package com.finances.core.usecase.bank

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.exception.EntityNotFoundException
import com.finances.core.model.Bank
import com.finances.core.port.input.BankPort

class UpdateBankUseCase(private val bankPort: BankPort) {
    private val MSG_EXISTS = "Codigo de Banco já utilizada no sistema!"
    private val MSG_NOT_FOUND = "Banco não encontrado!"

    fun execute(bank: Bank) =
        when (validate(bank)) {
            true -> bankPort.save(bank)
            false -> throw EntityAlreadyExistsException(MSG_EXISTS)
        }

    private fun validate(bank: Bank) =
        when (bankPort.findById(bank.id).isPresent) {
            true -> !bankPort.existsByCode(bank.code, bank.id)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}