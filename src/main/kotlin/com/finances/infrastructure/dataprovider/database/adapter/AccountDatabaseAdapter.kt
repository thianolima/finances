package com.finances.infrastructure.dataprovider.database.adapter

import com.finances.core.model.Account
import com.finances.core.port.AccountDatabasePort
import com.finances.infrastructure.mapper.toEntity
import com.finances.infrastructure.mapper.toModel
import com.finances.infrastructure.dataprovider.database.repository.AccountRepository
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class AccountDatabaseAdapter(private val repository: AccountRepository):AccountDatabasePort{

    @Transactional
    override fun save(account: Account) =
        repository.save(account.toEntity())
            .toModel()

    @Transactional
    override fun delete(id: String) {
        repository.deleteById(id)
    }

    override fun findById(id: String) =
        repository.findById(id)
            .map {
                it.toModel()
            }

    override fun existsByBankId(idbank: String) =
        repository.findByBankId(idbank).isPresent
}