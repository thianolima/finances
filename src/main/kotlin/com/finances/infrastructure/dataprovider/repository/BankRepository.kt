package com.finances.infrastructure.dataprovider.repository

import com.finances.infrastructure.dataprovider.entity.BankEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BankRepository : JpaRepository<BankEntity, String> {

    @Query("select b from BankEntity b where b.id <> :id and b.code = :code")
    fun findByCodeAndId(code: String, id: String): Optional<BankEntity>
}
