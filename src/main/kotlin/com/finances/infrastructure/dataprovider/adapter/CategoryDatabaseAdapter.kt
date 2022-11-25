package com.finances.infrastructure.dataprovider.adapter

import com.finances.core.model.Category
import com.finances.core.port.CategoryDatabasePort
import com.finances.infrastructure.dataprovider.mapper.toEntity
import com.finances.infrastructure.dataprovider.mapper.toModel
import com.finances.infrastructure.dataprovider.repository.CategoryRepository
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class CategoryDatabaseAdapter(private val repository: CategoryRepository) : CategoryDatabasePort {

    @Transactional
    override fun save(category: Category) =
        repository.save(category.toEntity()).toModel()

    @Transactional
    override fun delete(id: String) =
        repository.deleteById(id)

    override fun existsByName(name: String) =
        repository.findByName(name).isPresent

    override fun findById(id: String) =
        repository.findById(id)
            .map {
                it.toModel()
            }
}