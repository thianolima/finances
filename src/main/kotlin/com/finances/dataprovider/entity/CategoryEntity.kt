package com.finances.dataprovider.entity

import com.finances.core.model.Category
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
data class CategoryEntity (
    @Id
    //@GenericGenerator(name = "UUIDGenerator", strategy = "uuid4")
    //@GeneratedValue(generator = "UUIDGenerator")
    val id : String,
    val name : String
)

fun CategoryEntity.toCategory() =
    Category(
        id = this.id,
        name = this.name
    )

fun Category.toCategoryEntity() =
    CategoryEntity(
        id = this.id,
        name = this.name
    )