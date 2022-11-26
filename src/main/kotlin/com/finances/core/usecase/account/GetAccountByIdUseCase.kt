package com.finances.core.usecase.account

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.port.AccountDatabasePort

class GetAccountByIdUseCase(private val accountDatabasePort: AccountDatabasePort) {

    private val MSG_NOT_FOUND = "Conta não encontrado!"

    fun execute(id: String) =
        accountDatabasePort.findById(id)
            .orElseThrow { EntityNotFoundException(MSG_NOT_FOUND) }
}
