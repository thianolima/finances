package com.finances.infrastructure.dataprovider.repository

import com.finances.infrastructure.dataprovider.entity.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository : JpaRepository<CategoryEntity, String> {
    fun findByName(name: String): Optional<CategoryEntity>
}
