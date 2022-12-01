package com.finances.core.usecase.account

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.exception.ExpenseUsingAccountException
import com.finances.core.port.AccountDatabasePort
import com.finances.core.port.ExpenseDatabasePort

class DeleteAccountUseCase(
    private val accountDatabasePort: AccountDatabasePort,
    private val expenseDatabasePort: ExpenseDatabasePort
) {
    private val MSG_USING = "A Conta esta sendo utilizado em uma ou mais despesas!"
    private val MSG_NOT_FOUND = "Conta não encontrada!"

    fun execute(id: String) =
        when (validate(id)) {
            true -> accountDatabasePort.delete(id)
            false -> throw ExpenseUsingAccountException(MSG_USING)
        }

    private fun validate(id: String) =
        when (accountDatabasePort.findById(id).isPresent) {
            true -> !expenseDatabasePort.existsByAccountId(id)
            false ->throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}