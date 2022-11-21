package com.finances.core.model

import java.util.*

data class Category(
    val id: String,
    val name: String
) {
    constructor(name: String) : this(
        id = UUID.randomUUID().toString(),
        name = name
    )
}