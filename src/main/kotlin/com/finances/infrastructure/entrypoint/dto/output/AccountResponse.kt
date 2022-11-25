package com.finances.infrastructure.entrypoint.dto.output

import io.swagger.v3.oas.annotations.media.Schema

class AccountResponse(
    @field:Schema(example = "e789bd9a-64d6-4f68-8fb1-051a3289e7ae", nullable = false)
    val id: String,

    @field:Schema(example = "Conta Corrente", nullable = false)
    val description: String,

    @field:Schema(example = "Itaú BBA S.A.", nullable = true)
    val bank: String
)