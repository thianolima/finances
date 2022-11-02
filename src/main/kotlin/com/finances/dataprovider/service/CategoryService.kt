package com.finances.dataprovider.service

import com.finances.core.gateway.CategoryGateway
import com.finances.core.model.Category
import com.finances.dataprovider.entity.toCategory
import com.finances.dataprovider.entity.toCategoryEntity
import com.finances.dataprovider.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(private val repository : CategoryRepository) : CategoryGateway {
    override fun save(category: Category) =
        repository.save(category.toCategoryEntity()).toCategory()
}