package com.finances.core.usecase.bank

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.port.BankDatabasePort

class DeleteBankUseCase(private val bankDatabasePort: BankDatabasePort) {

    private val MSG_NOT_FOUND = "Bnaco não encontrada!"

    fun execute(id: String) =
        when(bankDatabasePort.findById(id).isPresent){
            true -> bankDatabasePort.delete(id)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}