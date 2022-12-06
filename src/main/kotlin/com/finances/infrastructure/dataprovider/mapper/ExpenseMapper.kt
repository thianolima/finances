package com.finances.infrastructure.dataprovider.mapper

import com.finances.core.model.Account
import com.finances.core.model.Category
import com.finances.core.model.Expense
import com.finances.infrastructure.dataprovider.entity.ExpenseEntity
import com.finances.infrastructure.entrypoint.dto.input.ExpenseRequest
import com.finances.infrastructure.entrypoint.dto.output.ExpenseResponse

fun ExpenseEntity.toModel() =
    Expense(
        id = this.id,
        description = this.description,
        dueDate = this.dueDate,
        buyDate = this.buyDate,
        payDate = this.payDate,
        amount = this.amount,
        category = this.category.toModel(),
        account = this.account.toModel(),
        pay = this.pay
    )

fun Expense.toEntity() =
    ExpenseEntity(
        id = this.id,
        description = this.description,
        buyDate = this.buyDate,
        dueDate = this.dueDate,
        payDate = this.payDate,
        amount = this.amount,
        category = this.category.toEntity(),
        account = this.account.toEntity(),
        pay = this.pay
    )

fun ExpenseRequest.toModel(category: Category, account: Account) =
    Expense(
        description = this.description,
        buyDate = this.buyDate,
        dueDate = this.dueDate,
        amount = this.amount,
        category = category,
        account = account
    )

fun ExpenseRequest.toModel(id: String, category: Category, account: Account) =
    Expense(
        id = id,
        description = this.description,
        dueDate = this.dueDate,
        buyDate = this.buyDate,
        payDate = this.payDate,
        pay = this.pay?:false,
        amount = this.amount,
        category = category,
        account = account
    )

fun Expense.toResponse() =
    ExpenseResponse(
        id = this.id,
        description = this.description,
        buyDate = this.buyDate,
        dueDate = this.dueDate,
        payDate = this.payDate,
        pay = this.pay,
        amount = this.amount,
        category = this.category.toResponse(),
        account = this.account.toResponse()
    )