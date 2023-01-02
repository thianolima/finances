package com.finances.core.repository

import com.finances.core.model.Account
import java.util.*

interface AccountRepository {
    fun save(account: Account): Account
    fun delete(id: String)
    fun findById(id: String): Optional<Account>
    fun existsByBankId(idbank: String): Boolean
}