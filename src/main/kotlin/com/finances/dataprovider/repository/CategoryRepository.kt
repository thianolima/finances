package com.finances.dataprovider.repository

import com.finances.core.model.Category
import com.finances.dataprovider.entity.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository : JpaRepository<CategoryEntity, String> {
    fun findByName(name:String) : Optional<CategoryEntity>
}
