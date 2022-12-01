package com.finances.core.port

import com.finances.core.model.Expense
import java.util.*

interface ExpenseDatabasePort {
    fun save(expense: Expense): Expense
    fun findById(id: String): Optional<Expense>
    fun existsByAccountId(idaccount: String): Boolean
}