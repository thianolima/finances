package com.finances.core.usecase.account

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.repository.AccountRepository

class FindAccountByIdUseCase(
    val accountRepository: AccountRepository
) {
    val MSG_NOT_FOUND = "Conta não encontrado!"

    fun execute(id: String) =
        accountRepository.findById(id)
            .orElseThrow { EntityNotFoundException(MSG_NOT_FOUND) }
}
