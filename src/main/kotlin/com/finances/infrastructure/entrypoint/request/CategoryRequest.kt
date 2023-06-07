package com.finances.infrastructure.entrypoint.request

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotBlank

@Schema(description = "Dados para inserir/atualizar categorias")
data class CategoryRequest(
    @field:Schema(example = "alimentacao", nullable = false)
    @field:NotBlank
    val name: String
)