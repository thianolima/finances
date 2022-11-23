package com.finances.core.port

import com.finances.core.model.Category
import java.util.*

interface CategoryDatabasePort {
    fun save(category: Category): Category
    fun existsByName(name: String): Boolean
    fun delete(id: String)
    fun findById(id: String): Optional<Category>
}