package com.finances.infrastructure.entrypoint.request

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ExpenseRequest(
    @field:Schema(example = "coxinha de frango", nullable = false)
    @field:NotBlank
    val description: String,

    @field:Schema(example = "2023-06-01", nullable = false)
    @field:NotNull
    val buyDate: LocalDate,

    @field:Schema(example = "2023-06-01", nullable = false)
    @field:NotNull
    val dueDate: LocalDate,

    @field:Schema(example = "2023-06-01", nullable = true)
    val payDate: LocalDate?,

    @field:Schema(example = "true", nullable = true)
    val pay: Boolean?,

    @field:Schema(example = "10.00", nullable = false)
    @field:NotNull
    val amount: Double,

    @field:Schema(example = "c88fc22d-8282-4fc9-9276-9afe7d4f8b12", nullable = false)
    @field:NotBlank
    val idaccount: String,

    @field:Schema(example = "c88fc22d-8282-4fc9-9276-9afe7d4f8b12", nullable = false)
    @field:NotBlank
    val idcategory: String,
)