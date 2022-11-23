package com.finances.infrastructure.dataprovider.repository

import com.finances.infrastructure.dataprovider.entity.BankEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BankRepository : JpaRepository<BankEntity, String> {

    //@Query("from BankEntity b where b.code :code and b.id <> :id")
    fun findByCodeAndIdNot(code: String, id: String): Optional<BankEntity>
}
