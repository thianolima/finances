package com.finances.infrastructure.entrypoint.dto.input

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotBlank

@Schema(description = "Dados para inserir/atualizar categorias")
data class CategoryRequest(
    @field:Schema(example = "Saude", nullable = false)
    @field:NotBlank
    val name: String
)