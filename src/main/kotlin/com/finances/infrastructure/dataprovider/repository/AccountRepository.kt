package com.finances.infrastructure.dataprovider.repository

import com.finances.core.model.Account
import com.finances.infrastructure.dataprovider.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<AccountEntity, String>{

}