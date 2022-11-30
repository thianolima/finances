package com.finances.core.model

import com.finances.core.exception.DomainException
import java.time.LocalDate
import java.util.*

data class Expense(
    val id: String,
    val description: String,
    val dueDate: LocalDate,
    val buyDate: LocalDate,
    val payDate: LocalDate?,
    val amount: Double,
    val category: Category,
    val account: Account,
    val pay: Boolean
) {
    init {
        if(this.amount <= 0.00)
            throw DomainException("O Valor da Despesa precisa ser maior do que zero!")

        if(this.dueDate.isBefore(this.buyDate))
            throw DomainException("A data de vencimento não pode ser menor do que a da compra")

        if(this.buyDate.isAfter(this.dueDate))
            throw DomainException("A data da compra não pode ser maior que a do vencimento")

        if(this.payDate?.isBefore(this.buyDate) == true)
            throw DomainException("A data do pagamento não pode ser menor que a da compra")
    }

    constructor(
        id: String,
        description: String,
        buyDate: LocalDate,
        dueDate: LocalDate,
        amount: Double,
        category: Category,
        payDate: LocalDate?,
        account: Account
    ) : this(
        id = UUID.randomUUID().toString(),
        description = description,
        buyDate = buyDate,
        dueDate =  dueDate,
        payDate = payDate,
        amount = amount,
        category = category,
        account = account,
        pay = false
    )
}