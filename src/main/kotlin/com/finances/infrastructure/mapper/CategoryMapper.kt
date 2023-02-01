package com.finances.infrastructure.mapper

import com.finances.core.model.Category
import com.finances.infrastructure.dataprovider.database.entity.CategoryEntity
import com.finances.infrastructure.entrypoint.response.CategoryResponse

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