package com.finances.core.usecase.bank

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.port.input.BankPort

class DeleteBankUseCase(private val bankPort: BankPort) {

    private val MSG_NOT_FOUND = "Bnaco não encontrada!"

    fun execute(id: String) =
        when(bankPort.findById(id).isPresent){
            true -> bankPort.delete(id)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}