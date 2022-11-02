package com.finances.core.gateway

import com.finances.core.model.Category

interface CategoryGateway {
    fun save(category : Category) : Category
    fun existsByName(name : String) : Boolean
}