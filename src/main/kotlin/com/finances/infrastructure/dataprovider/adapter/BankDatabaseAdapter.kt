package com.finances.infrastructure.dataprovider.adapter

import com.finances.core.model.Bank
import com.finances.core.port.BankDatabasePort
import com.finances.infrastructure.dataprovider.mapper.toEntity
import com.finances.infrastructure.dataprovider.mapper.toModel
import com.finances.infrastructure.dataprovider.repository.BankRepository
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class BankDatabaseAdapter(private val repository: BankRepository) : BankDatabasePort {

    @Transactional
    override fun save(bank: Bank) =
        repository.save(bank.toEntity())
            .toModel()

    @Transactional
    override fun delete(id: String) =
        repository.deleteById(id)

    override fun existsByCodeAndId(code: String, id: String) =
        repository.findByCodeAndId(code, id).isPresent

    override fun findById(id: String) =
        repository.findById(id)
            .map {
                it.toModel()
            }
}