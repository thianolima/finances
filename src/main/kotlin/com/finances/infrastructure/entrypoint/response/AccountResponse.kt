package com.finances.infrastructure.entrypoint.response

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Conta")
class AccountResponse(
    @field:Schema(example = "e789bd9a-64d6-4f68-8fb1-051a3289e7ae", nullable = false)
    val id: String,

    @field:Schema(example = "Conta Corrente", nullable = false)
    val description: String,

    val bank: BankResponse
)