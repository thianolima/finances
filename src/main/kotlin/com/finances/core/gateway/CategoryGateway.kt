package com.finances.core.gateway

import com.finances.core.model.Category

interface CategoryGateway {
    fun save(category : Category) : Category
    //fun delete(category : Category)
    //fun findAll() : List<Category>
    //fun findById(id : String) : Category
    //fun findByName(name : String) : Category
}