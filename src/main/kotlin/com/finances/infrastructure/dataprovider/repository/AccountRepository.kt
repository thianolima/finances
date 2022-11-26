package com.finances.infrastructure.dataprovider.repository

import com.finances.infrastructure.dataprovider.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountRepository : JpaRepository<AccountEntity, String> {

    @Query("select a from AccountEntity a " +
           "join fetch a.bank b " +
           "where a.bank.id = :idbank")
    fun findByBankId(idbank: String): Optional<AccountEntity>
}