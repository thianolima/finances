package com.finances.infrastructure.mapper

import com.finances.core.model.Bank
import com.finances.infrastructure.dataprovider.database.entity.BankEntity
import com.finances.infrastructure.entrypoint.response.BankResponse

fun BankEntity.toModel() =
    Bank(
        id = this.id,
        name = this.name,
        code = this.code
    )

fun Bank.toEntity() =
    BankEntity(
        id = this.id,
        name = this.name,
        code = this.code
    )

fun Bank.toResponse() =
    BankResponse(
        id = this.id,
        name = this.name,
        code = this.code
    )