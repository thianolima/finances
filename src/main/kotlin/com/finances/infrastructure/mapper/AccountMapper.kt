package com.finances.infrastructure.mapper

import com.finances.core.model.Account
import com.finances.core.model.Bank
import com.finances.infrastructure.dataprovider.entity.AccountEntity
import com.finances.infrastructure.entrypoint.dto.input.AccountRequest
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
        bank = this.bank.toResponse()
    )

fun AccountRequest.toModel(bank: Bank) =
    Account(
        description = this.description,
        bank = bank
    )

fun AccountRequest.toModel(id: String, bank: Bank) =
    Account(
        id = id,
        description = this.description,
        bank = bank
    )