package com.finances.infrastructure.dataprovider.database.repository

import com.finances.core.model.Account
import com.finances.core.repository.AccountRepository
import com.finances.infrastructure.dataprovider.database.entity.AccountEntity
import com.finances.infrastructure.mapper.toEntity
import com.finances.infrastructure.mapper.toModel
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Repository
class AccountRepositoryJPA(
    @PersistenceContext
    private val entityManager: EntityManager
) : AccountRepository {

    @Transactional
    override fun save(account: Account) =
        entityManager.merge(account.toEntity()).toModel()

    @Transactional
    override fun delete(id: String) =
        entityManager.remove(
            entityManager.find(AccountEntity::class.java, id)
        )

    override fun findById(id: String) =
        entityManager.find(AccountEntity::class.java, id)
            ?.let {
                Optional.of(it.toModel())
            }
            ?:run {
                Optional.empty<Account>()
            }

    override fun existsByBankId(idbank: String): Boolean {
        val criteriaBuilder = entityManager.criteriaBuilder
        val criteriaQuery = criteriaBuilder.createQuery(AccountEntity::class.java)
        val root = criteriaQuery.from(AccountEntity::class.java)
        criteriaQuery.select(root)
            .where(
                criteriaBuilder.equal(root.get<String>("bank").get<String>("id"), idbank)
            )
        val query = entityManager.createQuery(criteriaQuery)
        val resultList = query.resultList
        return resultList.size > 0
    }
}