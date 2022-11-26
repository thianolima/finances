package com.finances.core.usecase.account

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.port.AccountDatabasePort

class DeleteAccountUseCase(private val accountDatabasePort: AccountDatabasePort) {

    private val MSG_NOT_FOUND = "Conta não encontrada!"

    fun execute(id: String) =
        when (accountDatabasePort.findById(id).isPresent) {
            true -> accountDatabasePort.delete(id)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}