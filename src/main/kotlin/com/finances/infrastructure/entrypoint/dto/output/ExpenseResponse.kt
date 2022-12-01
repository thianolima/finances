package com.finances.infrastructure.entrypoint.dto.output

import com.finances.core.model.Account
import com.finances.core.model.Category
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema(description = "Despesa")
data class ExpenseResponse (
    @field:Schema(example = "c88fc22d-8282-4fc9-9276-9afe7d4f8b12")
    val id: String,

    @field:Schema(example = "Casas Bahia")
    val description: String,

    @field:Schema(example = "2022-12-01")
    val dueDate: LocalDate,

    @field:Schema(example = "2022-12-01")
    val buyDate: LocalDate,

    @field:Schema(example = "2022-12-01")
    val payDate: LocalDate?,

    @field:Schema(example = "10.00")
    val amount: Double,

    val category: Category,
    val account: Account,

    @field:Schema(example = "false")
    val pay: Boolean
)