package com.finances.core.model

import java.util.*

data class Bank(
    val id: String,
    val code: String,
    val name: String
) {
    constructor(code: String, name: String) : this(
        id = UUID.randomUUID().toString(),
        code = code,
        name = name
    )
}