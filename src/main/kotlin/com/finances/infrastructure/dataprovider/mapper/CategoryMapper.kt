package com.finances.infrastructure.dataprovider.mapper

import com.finances.core.model.Category
import com.finances.infrastructure.dataprovider.entity.CategoryEntity
import com.finances.infrastructure.entrypoint.dto.output.CategoryResponse

fun CategoryEntity.toCategory() =
    Category(
        id = this.id!!,
        name = this.name
    )

fun Category.toCategoryEntity() =
    CategoryEntity(
        id = this.id,
        name = this.name
    )

fun Category.toResponse() =
    CategoryResponse(
        id = this.id,
        name = this.name
    )