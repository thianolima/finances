package com.finances.infrastructure.dataprovider.entity

import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "category")
@DynamicUpdate
data class CategoryEntity(
    @Id
    var id: String,
    var name: String
)
