package com.finances.infrastructure.dataprovider.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@Table(name = "account")
@DynamicUpdate
class AccountEntity(
    @Id
    val id: String,
    val description: String,
    @ManyToOne
    @JoinColumn(name = "idbank", nullable = false, foreignKey= ForeignKey(name = "fk_account_bank"))
    var bank : BankEntity
)