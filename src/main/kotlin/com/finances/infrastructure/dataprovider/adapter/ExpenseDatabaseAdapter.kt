package com.finances.infrastructure.dataprovider.adapter

import com.finances.core.model.Expense
import com.finances.core.port.ExpenseDatabasePort
import com.finances.infrastructure.dataprovider.mapper.toEntity
import com.finances.infrastructure.dataprovider.mapper.toModel
import com.finances.infrastructure.dataprovider.repository.ExpenseRepository
import org.springframework.stereotype.Component

@Component
class ExpenseDatabaseAdapter(private val repository: ExpenseRepository) : ExpenseDatabasePort {
    override fun save(expense: Expense) =
        repository.save(expense.toEntity()).toModel()

    override fun findById(id: String) =
        repository.findById(id)
            .map {
                it.toModel()
            }
}