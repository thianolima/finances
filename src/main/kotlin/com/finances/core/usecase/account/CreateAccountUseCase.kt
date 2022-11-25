package com.finances.core.usecase.account

import com.finances.core.model.Account
import com.finances.core.port.AccountDatabasePort

class CreateAccountUseCase(private val accountDatabasePort: AccountDatabasePort) {

    fun execute(account: Account) =
        accountDatabasePort.save(account)
}