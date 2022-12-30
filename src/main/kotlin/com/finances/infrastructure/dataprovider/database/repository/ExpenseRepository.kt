package com.finances.infrastructure.dataprovider.database.repository

import com.finances.infrastructure.dataprovider.database.entity.ExpenseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ExpenseRepository : JpaRepository<ExpenseEntity, String> {

    @Query("select count(e) from ExpenseEntity e " +
           "where e.account.id = :idaccount")
    fun findByAccountId(idaccount: String): Long
}