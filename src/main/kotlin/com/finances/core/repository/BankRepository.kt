package com.finances.core.repository

import com.finances.core.model.Bank
import java.util.*

interface BankRepository {
    fun save(bank: Bank): Bank
    fun existsByCodeAndId(code: String, id: String): Boolean
    fun delete(id: String)
    fun findById(id: String): Optional<Bank>
}