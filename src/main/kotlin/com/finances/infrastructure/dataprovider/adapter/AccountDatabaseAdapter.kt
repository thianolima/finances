package com.finances.infrastructure.dataprovider.adapter

import com.finances.core.model.Account
import com.finances.core.port.AccountDatabasePort
import com.finances.infrastructure.dataprovider.mapper.toEntity
import com.finances.infrastructure.dataprovider.mapper.toModel
import com.finances.infrastructure.dataprovider.repository.AccountRepository
import org.springframework.stereotype.Component
import java.util.*
import javax.transaction.Transactional

@Component
class AccountDatabaseAdapter(private val repository: AccountRepository):AccountDatabasePort{

    @Transactional
    override fun save(account: Account) =
        repository.save(account.toEntity()).toModel()

    @Transactional
    override fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): Optional<Account> {
        TODO("Not yet implemented")
    }
}