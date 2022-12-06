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
    val pay: Boolean = false,
    val amount: Double,
    val category: Category,
    val account: Account
) {
    init {
        if(this.amount <= 0.00)
            throw DomainException("O Valor da Despesa precisa ser maior do que zero!")

        if(this.dueDate.isBefore(this.buyDate))
            throw DomainException("A data de vencimento não pode ser menor do que a da compra!")

        if(this.buyDate.isAfter(this.dueDate))
            throw DomainException("A data da compra não pode ser maior que a do vencimento!")

        if(this.payDate?.isBefore(this.buyDate) == true)
            throw DomainException("A data do pagamento não pode ser menor que a da compra!")

        if(this.pay && this.payDate == null)
            throw DomainException("A Data de Pagamento não pode estar vazia para ao se tornar Paga!")

        if(!this.pay && this.payDate != null)
            throw DomainException("Uma despesa não pode ter uma Data de Pagamento sem estar Paga!")
    }

    constructor(
        description: String,
        buyDate: LocalDate,
        dueDate: LocalDate,
        amount: Double,
        category: Category,
        account: Account
    ) : this(
        id = UUID.randomUUID().toString(),
        description = description,
        buyDate = buyDate,
        dueDate =  dueDate,
        amount = amount,
        category = category,
        account = account,
        payDate = null,
        pay = false
    )
}