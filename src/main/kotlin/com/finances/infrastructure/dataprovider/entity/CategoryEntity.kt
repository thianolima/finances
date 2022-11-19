package com.finances.infrastructure.dataprovider.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "category")
@DynamicUpdate
data class CategoryEntity(
    @Id
    //@GenericGenerator(name = "UUIDGenerator", strategy = "uuid4")
    //@GeneratedValue(generator = "UUIDGenerator")
    val id: String,
    val name: String
)