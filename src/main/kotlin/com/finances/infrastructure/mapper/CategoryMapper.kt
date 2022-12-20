package com.finances.infrastructure.mapper

import com.finances.core.model.Category
import com.finances.infrastructure.dataprovider.entity.CategoryEntity
import com.finances.infrastructure.entrypoint.dto.output.CategoryResponse

fun CategoryEntity.toModel() =
    Category(
        id = this.id,
        name = this.name
    )

fun Category.toEntity() =
    CategoryEntity(
        id = this.id,
        name = this.name
    )

fun Category.toResponse() =
    CategoryResponse(
        id = this.id,
        name = this.name
    )