package com.finances.infrastructure.entrypoint.request

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotBlank

class AccountRequest (
    @field:Schema(example = "Conta Corrente")
    @field:NotBlank
    val description: String,

    @field:Schema(example = "c88fc22d-8282-4fc9-9276-9afe7d4f8b12")
    @field:NotBlank
    val idbank: String
)