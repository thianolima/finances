package com.finances.infrastructure.entrypoint.dto.output

import com.finances.core.model.Account
import com.finances.core.model.Category
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema(description = "Despesa")
data class ExpenseResponse (
    val id: String,
    val description: String,
    val dueDate: LocalDate,
    val buyDate: LocalDate,
    val payDate: LocalDate?,
    val amount: Double,
    val category: Category,
    val account: Account,
    val pay: Boolean
)