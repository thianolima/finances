package com.finances.infrastructure.entrypoint.dto.input

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotBlank

@Schema(description = "Dados para inserir/atualizar bancos")
data class BankRequest (
    @field:Schema(example = "184", nullable = false)
    @field:NotBlank
    val code: String,

    @field:Schema(example = "Banco Itaú BBA S.A.", nullable = false)
    @field:NotBlank
    val name: String
)