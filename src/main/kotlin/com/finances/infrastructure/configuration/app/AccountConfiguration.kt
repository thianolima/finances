package com.finances.infrastructure.configuration.app

import com.finances.core.usecase.account.CreateAccountUseCase
import com.finances.core.usecase.account.DeleteAccountUseCase
import com.finances.core.usecase.account.GetAccountByIdUseCase
import com.finances.core.usecase.account.UpdateAccountUseCase
import com.finances.infrastructure.dataprovider.database.adapter.AccountDatabaseAdapter
import com.finances.infrastructure.dataprovider.database.adapter.ExpenseDatabaseAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AccountConfiguration {

    @Bean
    fun createAccountUseCase(accountDatabaseAdapter: AccountDatabaseAdapter) =
        CreateAccountUseCase(accountDatabaseAdapter)

    @Bean
    fun getByAccountUseCase(accountDatabaseAdapter: AccountDatabaseAdapter) =
        GetAccountByIdUseCase(accountDatabaseAdapter)

    @Bean
    fun updateAccountUseCase(accountDatabaseAdapter: AccountDatabaseAdapter) =
        UpdateAccountUseCase(accountDatabaseAdapter)

    @Bean
    fun deleteAccountUseCase(accountDatabaseAdapter: AccountDatabaseAdapter, expenseDatabaseAdapter: ExpenseDatabaseAdapter) =
        DeleteAccountUseCase(accountDatabaseAdapter, expenseDatabaseAdapter)
}