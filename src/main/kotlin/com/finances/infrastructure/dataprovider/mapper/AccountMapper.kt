package com.finances.infrastructure.dataprovider.mapper

import com.finances.core.model.Account
import com.finances.infrastructure.dataprovider.entity.AccountEntity
import com.finances.infrastructure.entrypoint.dto.output.AccountResponse

fun AccountEntity.toModel() =
    Account(
        id = this.id,
        description = this.description,
        bank = this.bank.toModel()
    )

fun Account.toEntity() =
    AccountEntity(
        id = this.id,
        description = this.description,
        bank = this.bank.toEntity()
    )

fun Account.toResponse() =
    AccountResponse(
        id = this.id,
        description = this.description,
        bank = this.bank.name
    )