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
    fun createBankUseCase(bankDatabaseAdapter: BankDatabaseAdapter) =
        CreateBankUseCase(bankDatabaseAdapter)

    @Bean
    fun deleteBankUseCase(bankDatabaseAdapter: BankDatabaseAdapter) =
        DeleteBankUseCase(bankDatabaseAdapter)

    @Bean
    fun updateBankUseCase(bankDatabaseAdapter: BankDatabaseAdapter) =
        UpdateBankUseCase(bankDatabaseAdapter)

    @Bean
    fun getBankByIdUseCase(bankDatabaseAdapter: BankDatabaseAdapter) =
        GetBankByIdUseCase(bankDatabaseAdapter)
}