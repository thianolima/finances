package com.finances.infrastructure.dataprovider.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "bank")
@DynamicUpdate
data class BankEntity(
    @Id
    val id: String,
    val code: String,
    val name: String
)