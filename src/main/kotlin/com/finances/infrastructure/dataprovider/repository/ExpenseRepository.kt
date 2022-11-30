package com.finances.infrastructure.dataprovider.repository

import com.finances.infrastructure.dataprovider.entity.ExpenseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExpenseRepository : JpaRepository<ExpenseEntity, String> {
}