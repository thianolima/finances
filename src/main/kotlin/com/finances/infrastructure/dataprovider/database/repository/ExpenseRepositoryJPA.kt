package com.finances.infrastructure.dataprovider.database.repository

import com.finances.core.model.Expense
import com.finances.core.repository.ExpenseRepository
import com.finances.infrastructure.dataprovider.database.entity.ExpenseEntity
import com.finances.infrastructure.mapper.toEntity
import com.finances.infrastructure.mapper.toModel
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Repository
class ExpenseRepositoryJPA(
    @PersistenceContext
    private val entityManager: EntityManager
): ExpenseRepository {

    @Transactional
    override fun save(expense: Expense) =
        entityManager.merge(expense.toEntity())
            .toModel()

    override fun findById(id: String) =
        entityManager.find(ExpenseEntity::class.java, id)
            ?.let {
                Optional.of(it.toModel())
            }
            ?:run {
                Optional.empty<Expense>()
            }

    override fun existsByAccountId(idaccount: String): Boolean {
        val criteriaBuilder = entityManager.criteriaBuilder
        val criteriaQuery = criteriaBuilder.createQuery(ExpenseEntity::class.java)
        val root = criteriaQuery.from(ExpenseEntity::class.java)
        criteriaQuery.select(root)
            .where(
                criteriaBuilder.equal(root.get<String>("account").get<String>("id"), idaccount),
            )
        val query = entityManager.createQuery(criteriaQuery)
        val resultList = query.resultList
        return resultList.size > 0
    }

    override fun existsByCategoryId(idcategory: String): Boolean {
        val criteriaBuilder = entityManager.criteriaBuilder
        val criteriaQuery = criteriaBuilder.createQuery(ExpenseEntity::class.java)
        val root = criteriaQuery.from(ExpenseEntity::class.java)
        criteriaQuery.select(root)
            .where(
                criteriaBuilder.equal(root.get<String>("category").get<String>("id"), idcategory),
            )
        val query = entityManager.createQuery(criteriaQuery)
        val resultList = query.resultList
        return resultList.size > 0
    }

    override fun existsByBuyDateAndAmount(buyDate: LocalDate, amount: Double): Optional<Expense> {
        val builder = entityManager.criteriaBuilder
        val query = builder.createQuery(ExpenseEntity::class.java)
        val root = query.from(ExpenseEntity::class.java)
        val isBuyDate = builder.equal(root.get<LocalDate>("buyDate"),buyDate)
        val isAmount =  builder.equal(root.get<Double>("amount"), amount)
        query.where(builder.and(isBuyDate, isAmount))
        val result = entityManager.createQuery(query.select(root)).resultList.first().toModel()
        return Optional.of(result)
    }
}