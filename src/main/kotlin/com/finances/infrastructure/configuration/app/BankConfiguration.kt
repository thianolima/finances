package com.finances.infrastructure.configuration.app

import com.finances.core.usecase.bank.CreateBankUseCase
import com.finances.core.usecase.bank.DeleteBankUseCase
import com.finances.core.usecase.bank.GetBankByIdUseCase
import com.finances.core.usecase.bank.UpdateBankUseCase
import com.finances.infrastructure.dataprovider.adapter.BankDatabaseAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BankConfiguration {
    @Bean
    fun createBankUseCase(bankRepositoryAdapter: BankDatabaseAdapter) =
        CreateBankUseCase(bankRepositoryAdapter)

    @Bean
    fun deleteBankUseCase(bankRepositoryAdapter: BankDatabaseAdapter) =
        DeleteBankUseCase(bankRepositoryAdapter)

    @Bean
    fun updateBankUseCase(bankRepositoryAdapter: BankDatabaseAdapter) =
        UpdateBankUseCase(bankRepositoryAdapter)

    @Bean
    fun getBankByIdUseCase(bankRepositoryAdapter: BankDatabaseAdapter) =
        GetBankByIdUseCase(bankRepositoryAdapter)
}