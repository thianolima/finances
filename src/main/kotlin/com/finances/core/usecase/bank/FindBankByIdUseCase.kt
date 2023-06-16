package com.finances.core.usecase.bank

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.repository.BankRepository

class FindBankByIdUseCase(private val bankRepository: BankRepository) {
    private val MSG_NOT_FOUND = "Banco não encontrado!"

    fun execute(id: String) =
        bankRepository.findById(id)
            .orElseThrow { EntityNotFoundException(MSG_NOT_FOUND) }
}
