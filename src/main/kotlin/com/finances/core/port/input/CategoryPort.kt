package com.finances.core.port.input

import com.finances.core.model.Category
import java.util.*

interface CategoryPort {
    fun save(category: Category): Category
    fun existsByName(name: String): Boolean
    fun delete(id: String)
    fun findById(id: String): Optional<Category>
}