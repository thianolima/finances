package com.finances.core.usecase.bank

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.model.Bank
import com.finances.core.port.BankDatabasePort

class CreateBankUseCase(private val bankDatabasePort: BankDatabasePort) {

    private val MSG_EXISTS = "Codigo de Banco já utilizada no sistema!"

    fun execute(bank: Bank) =
        when (bankDatabasePort.existsByCodeAndId(bank.code, bank.id)) {
            true -> throw EntityAlreadyExistsException(MSG_EXISTS)
            false -> bankDatabasePort.save(bank)
        }
}