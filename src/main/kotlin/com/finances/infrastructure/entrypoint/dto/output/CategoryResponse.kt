package com.finances.infrastructure.entrypoint.dto.output

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Categoria")
data class CategoryResponse(
    @field:Schema(example = "c88fc22d-8282-4fc9-9276-9afe7d4f8b12")
    val id: String,

    @field:Schema(example = "Saude")
    val name: String
)