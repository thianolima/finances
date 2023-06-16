package com.finances.core.repository

import com.finances.core.model.Expense
import java.time.LocalDate
import java.util.*

interface ExpenseRepository {
    fun save(expense: Expense): Expense
    fun findById(id: String): Optional<Expense>
    fun existsByAccountId(idaccount: String): Boolean
    fun existsByCategoryId(idcategory: String): Boolean
    fun findByBuyDateAndAmount(buyDate: LocalDate, amount: Double): Optional<Expense>
    fun findByDescribe(describe: String)
}