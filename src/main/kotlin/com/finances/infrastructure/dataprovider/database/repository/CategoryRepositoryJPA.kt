package com.finances.infrastructure.dataprovider.database.repository

import com.finances.core.model.Category
import com.finances.core.repository.CategoryRepository
import com.finances.infrastructure.dataprovider.database.entity.CategoryEntity
import com.finances.infrastructure.mapper.toEntity
import com.finances.infrastructure.mapper.toModel
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Repository
class CategoryRepositoryJPA(
    @PersistenceContext
    private val entityManager: EntityManager
) : CategoryRepository {

    @Transactional
    override fun save(category: Category) =
        entityManager.merge(category.toEntity())
            .toModel()

    @Transactional
    override fun delete(id: String) =
        entityManager.remove(
            entityManager.find(CategoryEntity::class.java, id)
        )

    override fun existsByName(name: String): Boolean {
        val criteriaBuilder = entityManager.criteriaBuilder
        val criteriaQuery = criteriaBuilder.createQuery(CategoryEntity::class.java)
        val root = criteriaQuery.from(CategoryEntity::class.java)
        criteriaQuery.select(root)
            .where(
                criteriaBuilder.equal(root.get<String>("name"), name),
            )
        val query = entityManager.createQuery(criteriaQuery)
        val resultList = query.resultList
        return resultList.size > 0
    }

    override fun findById(id: String) =
        entityManager.find(CategoryEntity::class.java, id)
            ?.let {
                Optional.of(it.toModel())
            }
            ?:run {
                Optional.empty<Category>()
            }
}