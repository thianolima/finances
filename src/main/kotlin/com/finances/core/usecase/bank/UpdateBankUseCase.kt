package com.finances.core.usecase.bank

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.exception.EntityNotFoundException
import com.finances.core.model.Bank
import com.finances.core.repository.BankRepository

class UpdateBankUseCase(private val bankRepository: BankRepository) {
    private val MSG_EXISTS = "Codigo de Banco já utilizado no sistema!"
    private val MSG_NOT_FOUND = "Banco não encontrado!"

    fun execute(bank: Bank) =
        when (validate(bank)) {
            true -> bankRepository.save(bank)
            false -> throw EntityAlreadyExistsException(MSG_EXISTS)
        }

    private fun validate(bank: Bank) =
        when (bankRepository.findById(bank.id).isPresent) {
            true -> !bankRepository.existsByCodeAndId(bank.code, bank.id)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}