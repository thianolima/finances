package com.finances.infrastructure.configuration.app

import com.finances.core.usecase.account.CreateAccountUseCase
import com.finances.infrastructure.dataprovider.adapter.AccountDatabaseAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AccountConfiguration {

    @Bean
    fun createAccountUseCase(accountDatabaseAdapter: AccountDatabaseAdapter) =
        CreateAccountUseCase(accountDatabaseAdapter)
}