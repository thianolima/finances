package com.finances.core.model

import java.util.*

data class Account (
    val id: String,
    val description: String,
    val bank : Bank
){
    constructor(description: String, bank: Bank) : this(
        id = UUID.randomUUID().toString(),
        description = description,
        bank = bank
    )
}