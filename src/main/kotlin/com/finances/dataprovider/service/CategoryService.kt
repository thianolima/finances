package com.finances.dataprovider.service

import com.finances.core.gateway.CategoryGateway
import com.finances.core.model.Category
import com.finances.dataprovider.entity.toCategory
import com.finances.dataprovider.entity.toCategoryEntity
import com.finances.dataprovider.repository.CategoryRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class CategoryService(private val repository : CategoryRepository) : CategoryGateway {
    @Transactional
    override fun save(category: Category) =
        repository.save(category.toCategoryEntity()).toCategory()

    override fun existsByName(name: String) =
        repository.findByName(name).isPresent
    @Transactional
    override fun delete(id : String) =
        repository.deleteById(id.toString())

    override fun findById(id : String) =
        repository.findById(id.toString())
            .map {
                Category(it.id, it.name)
            }
}