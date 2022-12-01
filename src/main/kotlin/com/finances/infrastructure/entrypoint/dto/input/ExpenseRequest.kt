package com.finances.infrastructure.entrypoint.dto.input

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ExpenseRequest(
    @field:Schema(example = "Casas Bahia")
    @field:NotBlank
    val description: String,

    @field:Schema(example = "Casas Bahia")
    @field:NotNull
    val buyDate: LocalDate,

    @field:Schema(example = "Casas Bahia")
    @field:NotNull
    val dueDate: LocalDate,

    @field:Schema(example = "Casas Bahia")
    @field:NotNull
    val amount: Double,

    @field:Schema(example = "c88fc22d-8282-4fc9-9276-9afe7d4f8b12")
    @field:NotBlank
    val idaccount: String,

    @field:Schema(example = "c88fc22d-8282-4fc9-9276-9afe7d4f8b12")
    @field:NotBlank
    val idcategory: String,
)