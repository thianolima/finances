package com.finances.infrastructure.dataprovider.service

import com.finances.core.model.Category
import com.finances.core.port.input.CategoryPort
import com.finances.infrastructure.dataprovider.mapper.toCategory
import com.finances.infrastructure.dataprovider.mapper.toCategoryEntity
import com.finances.infrastructure.dataprovider.repository.CategoryRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class CategoryService(private val repository: CategoryRepository) : CategoryPort {

    @Transactional
    override fun save(category: Category) =
        repository.save(category.toCategoryEntity()).toCategory()

    override fun existsByName(name: String) =
        repository.findByName(name).isPresent

    @Transactional
    override fun delete(id: String) =
        repository.deleteById(id.toString())

    override fun findById(id : String) =
        repository.findById(id.toString())
            .map {
                it.toCategory()
            }
}