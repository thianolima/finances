package com.finances.infrastructure.dataprovider.database.adapter

import com.finances.core.model.Expense
import com.finances.core.port.ExpenseDatabasePort
import com.finances.infrastructure.mapper.toEntity
import com.finances.infrastructure.mapper.toModel
import com.finances.infrastructure.dataprovider.database.repository.ExpenseRepository
import org.springframework.stereotype.Component

@Component
class ExpenseDatabaseAdapter(private val repository: ExpenseRepository) : ExpenseDatabasePort {

    private val ZERO: Long = 0

    override fun save(expense: Expense) =
        repository.save(expense.toEntity())
            .toModel()

    override fun findById(id: String) =
        repository.findById(id)
            .map {
                it.toModel()
            }

    override fun existsByAccountId(idaccount: String) =
        repository.findByAccountId(idaccount) > ZERO
}