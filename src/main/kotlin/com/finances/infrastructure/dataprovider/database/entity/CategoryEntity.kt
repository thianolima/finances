package com.finances.infrastructure.dataprovider.database.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "category")
@DynamicUpdate
data class CategoryEntity(
    @Id
    val id: String,
    val name: String
)
