package com.finances.core.usecase.account

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.exception.ExpenseUsingAccountException
import com.finances.core.port.ExpenseDatabasePort
import com.finances.core.repository.AccountRepository

class DeleteAccountUseCase(
    private val accountRepository: AccountRepository,
    private val expenseDatabasePort: ExpenseDatabasePort
) {
    private val MSG_USING = "A Conta esta sendo utilizado em uma ou mais despesas!"
    private val MSG_NOT_FOUND = "Conta não encontrada!"

    fun execute(id: String) =
        when (validate(id)) {
            true -> accountRepository.delete(id)
            false -> throw ExpenseUsingAccountException(MSG_USING)
        }

    private fun validate(id: String) =
        when (accountRepository.findById(id).isPresent) {
            true -> !expenseDatabasePort.existsByAccountId(id)
            false ->throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}