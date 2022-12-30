package com.finances.infrastructure.dataprovider.database.repository

import com.finances.core.model.Bank
import com.finances.core.repository.BankRepository
import com.finances.infrastructure.dataprovider.database.entity.BankEntity
import com.finances.infrastructure.mapper.toEntity
import com.finances.infrastructure.mapper.toModel
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Repository
class BankRepositoryJPA(
    @PersistenceContext
    private val entityManager: EntityManager
) : BankRepository {

    @Transactional
    override fun save(bank: Bank) =
        entityManager.merge(bank.toEntity()).toModel()

    @Transactional
    override fun delete(id: String) =
        entityManager.remove(
            entityManager.find(BankEntity::class.java, id)
        )

    override fun existsByCodeAndId(code: String, id: String): Boolean {
        val criteriaBuilder = entityManager.criteriaBuilder
        val criteriaQuery = criteriaBuilder.createQuery(BankEntity::class.java)
        val root = criteriaQuery.from(BankEntity::class.java)
        criteriaQuery.select(root)
            .where(
                criteriaBuilder.equal(root.get<String>("code"), code),
                criteriaBuilder.notEqual(root.get<String>("id"), id)
            )
        val query = entityManager.createQuery(criteriaQuery)
        val resultList = query.resultList
        return resultList.size > 0
    }

    override fun findById(id: String) =
        entityManager.find(BankEntity::class.java, id)
            ?.let {
                Optional.of(it.toModel())
            }
            ?:run {
                Optional.empty<Bank>()
            }
}