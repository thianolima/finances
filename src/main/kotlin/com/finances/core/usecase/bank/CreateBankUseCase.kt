package com.finances.core.usecase.bank

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.model.Bank
import com.finances.core.model.Category
import com.finances.core.port.input.BankPort
import com.finances.core.port.input.CategoryPort

class CreateBankUseCase(private val bankPort: BankPort) {

    private val MSG_EXISTS = "Codigo de Banco já utilizada no sistema!"

    fun execute(bank: Bank) =
        when (bankPort.existsByCode(bank.code, bank.id)) {
            true -> throw EntityAlreadyExistsException(MSG_EXISTS)
            false -> bankPort.save(bank)
        }
}