package com.finances.core.usecase.bank

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.model.Bank
import com.finances.core.repository.BankRepository

class CreateBankUseCase(
    val bankRepository: BankRepository
) {

    private val MSG_EXISTS = "Codigo de Banco já utilizada no sistema!"

    fun execute(bank: Bank) =
        when (bankRepository.existsByCodeAndId(bank.code, bank.id)) {
            true -> throw EntityAlreadyExistsException(MSG_EXISTS)
            false -> bankRepository.save(bank)
        }
}