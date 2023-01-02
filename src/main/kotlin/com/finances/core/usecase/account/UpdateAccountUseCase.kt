package com.finances.core.usecase.account

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.model.Account
import com.finances.core.repository.AccountRepository

class UpdateAccountUseCase (private val accountRepository: AccountRepository){

    private val MSG_NOT_FOUND = "Conta não encontrada!"

    fun execute(account: Account) =
        when (accountRepository.findById(account.id).isPresent) {
            true -> accountRepository.save(account)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}