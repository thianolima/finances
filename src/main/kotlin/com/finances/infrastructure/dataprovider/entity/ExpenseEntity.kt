package com.finances.infrastructure.dataprovider.entity

import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "expense")
@DynamicUpdate
class ExpenseEntity(
    @Id
    val id: String,
    val description: String,
    val dueDate: LocalDate,
    val buyDate: LocalDate,
    val payDate: LocalDate?,
    val amount: Double,
    val pay: Boolean,
    @ManyToOne
    @JoinColumn(name = "idcategory", nullable = false, foreignKey= ForeignKey(name = "fk_expense_category"))
    val category: CategoryEntity,
    @ManyToOne
    @JoinColumn(name = "idaccount", nullable = false, foreignKey= ForeignKey(name = "fk_expense_account"))
    val account: AccountEntity
)