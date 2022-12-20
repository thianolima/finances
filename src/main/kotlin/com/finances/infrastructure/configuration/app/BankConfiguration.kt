package com.finances.infrastructure.configuration.app

import com.finances.core.usecase.bank.CreateBankUseCase
import com.finances.core.usecase.bank.DeleteBankUseCase
import com.finances.core.usecase.bank.GetBankByIdUseCase
import com.finances.core.usecase.bank.UpdateBankUseCase
import com.finances.infrastructure.dataprovider.adapter.AccountDatabaseAdapter
import com.finances.infrastructure.dataprovider.repository.BankRepositoryJPA
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BankConfiguration {

    @Bean
    fun createBankUseCase(bankRepository: BankRepositoryJPA) =
        CreateBankUseCase(bankRepository)

    @Bean
    fun deleteBankUseCase(bankRepository: BankRepositoryJPA, accountDatabaseAdapter: AccountDatabaseAdapter) =
        DeleteBankUseCase(bankRepository, accountDatabaseAdapter)

    @Bean
    fun updateBankUseCase(bankRepository: BankRepositoryJPA) =
        UpdateBankUseCase(bankRepository)

    @Bean
    fun getBankByIdUseCase(bankRepository: BankRepositoryJPA) =
        GetBankByIdUseCase(bankRepository)
}