package com.finances.infrastructure.configuration.app

import com.finances.core.usecase.account.CreateAccountUseCase
import com.finances.core.usecase.account.DeleteAccountUseCase
import com.finances.core.usecase.account.GetAccountByIdUseCase
import com.finances.core.usecase.account.UpdateAccountUseCase
import com.finances.infrastructure.dataprovider.database.adapter.ExpenseDatabaseAdapter
import com.finances.infrastructure.dataprovider.database.repository.AccountRepositoryJPA
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AccountConfiguration {

    @Bean
    fun createAccountUseCase(accountRepository: AccountRepositoryJPA) =
        CreateAccountUseCase(accountRepository)

    @Bean
    fun getByAccountUseCase(accountRepository: AccountRepositoryJPA) =
        GetAccountByIdUseCase(accountRepository)

    @Bean
    fun updateAccountUseCase(accountRepository: AccountRepositoryJPA) =
        UpdateAccountUseCase(accountRepository)

    @Bean
    fun deleteAccountUseCase(accountRepository: AccountRepositoryJPA, expenseDatabaseAdapter: ExpenseDatabaseAdapter) =
        DeleteAccountUseCase(accountRepository, expenseDatabaseAdapter)
}