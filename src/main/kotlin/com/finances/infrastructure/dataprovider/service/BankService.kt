package com.finances.infrastructure.dataprovider.service

import com.finances.core.model.Bank
import com.finances.core.port.input.BankPort
import com.finances.infrastructure.dataprovider.mapper.toEntity
import com.finances.infrastructure.dataprovider.mapper.toModel
import com.finances.infrastructure.dataprovider.repository.BankRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class BankService(private val repository: BankRepository) : BankPort {

    @Transactional
    override fun save(bank: Bank) =
        repository.save(bank.toEntity()).toModel()

    override fun existsByCodeAndId(code: String, id: String) =
        repository.findByCodeAndId(code, id).isPresent

    @Transactional
    override fun delete(id: String) =
        repository.deleteById(id)

    override fun findById(id: String) =
        repository.findById(id)
            .map {
                it.toModel()
            }
}