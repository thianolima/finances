package com.finances.core.gateway

import com.finances.core.model.Category
import java.util.*

interface CategoryGateway {
    fun save(category : Category) : Category
    fun existsByName(name : String) : Boolean
    fun delete(id : String)
    fun findById(id : String) : Optional<Category>
}