package com.finances.infrastructure.dataprovider.adapter

import com.finances.core.model.Expense
import com.finances.core.port.ExpenseDatabasePort
import com.finances.infrastructure.dataprovider.repository.ExpenseRepository
import org.springframework.stereotype.Component
import java.util.*
import javax.transaction.Transactional

@Component
class ExpenseDatabaseAdapter(private val repository: ExpenseRepository) : ExpenseDatabasePort {
    override fun save(expense: Expense): Expense {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): Optional<Expense> {
        TODO("Not yet implemented")
    }
}