package com.finances.core.usecase.bank

import com.finances.core.exception.AccountUsingBankException
import com.finances.core.exception.EntityNotFoundException
import com.finances.core.port.AccountDatabasePort
import com.finances.core.port.BankDatabasePort

class DeleteBankUseCase(
    private val bankDatabasePort: BankDatabasePort,
    private val accountDatabasePort: AccountDatabasePort
) {
    private val MSG_USING = "O Banco esta sendo utilizado em uma ou mais contas!"
    private val MSG_NOT_FOUND = "Banco não encontrado!"

    fun execute(id: String) =
        when (validate(id)) {
            true -> bankDatabasePort.delete(id)
            false -> throw AccountUsingBankException(MSG_USING)
        }

    private fun validate(id: String) =
        when (bankDatabasePort.findById(id).isPresent) {
            true -> !accountDatabasePort.existsByBankId(id)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}