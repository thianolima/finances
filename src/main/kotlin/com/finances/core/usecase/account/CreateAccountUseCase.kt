package com.finances.core.usecase.account

import com.finances.core.model.Account
import com.finances.core.repository.AccountRepository

class CreateAccountUseCase(
    val accountRepository: AccountRepository
) {

    fun execute(account: Account) =
        accountRepository.save(account)
}