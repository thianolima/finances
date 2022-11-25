package com.finances.core.port

import com.finances.core.model.Account
import java.util.*

interface AccountDatabasePort {
    fun save(account: Account): Account
    fun delete(id: String)
    fun findById(id: String): Optional<Account>
}