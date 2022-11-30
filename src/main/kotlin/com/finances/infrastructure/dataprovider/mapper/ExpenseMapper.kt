package com.finances.infrastructure.dataprovider.mapper

import com.finances.core.model.Expense
import com.finances.infrastructure.dataprovider.entity.ExpenseEntity
import java.time.LocalDate

class ExpenseMapper {
    fun ExpenseEntity.toModel() =
        Expense(
            id = this.id,
            description = this.description,
            buyDate = this.buyDate,
            dueDate =  this.dueDate,
            payDate = this.payDate,
            amount = this.amount,
            category = this.category.toModel(),
            account = this.account.toModel()
        )

    fun Expense.toEntity() =
        ExpenseEntity(
            id = this.id,
            description = this.description,
            buyDate = this.buyDate,
            dueDate =  this.dueDate,
            payDate = this.payDate,
            amount = this.amount,
            category = this.category.toEntity(),
            account = this.account.toEntity()
        )
}