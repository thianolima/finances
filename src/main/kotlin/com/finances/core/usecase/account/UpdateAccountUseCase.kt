package com.finances.core.usecase.account

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.model.Account
import com.finances.core.port.AccountDatabasePort

class UpdateAccountUseCase (private val accountDatabasePort: AccountDatabasePort){

    private val MSG_NOT_FOUND = "Conta não encontrada!"

    fun execute(account: Account) =
        when (accountDatabasePort.findById(account.id).isPresent) {
            true -> accountDatabasePort.save(account)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}