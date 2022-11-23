package com.finances.infrastructure.configuration.app

import com.finances.core.usecase.bank.CreateBankUseCase
import com.finances.core.usecase.bank.DeleteBankUseCase
import com.finances.core.usecase.bank.GetBankByIdUseCase
import com.finances.core.usecase.bank.UpdateBankUseCase
import com.finances.infrastructure.dataprovider.service.BankService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BankConfiguration {
    @Bean
    fun createBankUseCase(bankService: BankService) =
        CreateBankUseCase(bankService)

    @Bean
    fun deleteBankUseCase(bankService: BankService) =
        DeleteBankUseCase(bankService)

    @Bean
    fun updateBankUseCase(bankService: BankService) =
        UpdateBankUseCase(bankService)

    @Bean
    fun getBankByIdUseCase(bankService: BankService) =
        GetBankByIdUseCase(bankService)
}