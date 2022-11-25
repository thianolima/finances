package com.finances.infrastructure.entrypoint.controller

import com.finances.core.model.Account
import com.finances.core.usecase.account.CreateAccountUseCase
import com.finances.core.usecase.bank.GetBankByIdUseCase
import com.finances.infrastructure.dataprovider.mapper.toResponse
import com.finances.infrastructure.entrypoint.dto.input.AccountRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/accounts")
class AccountController(
    val createAccountUseCase: CreateAccountUseCase,
    val getBankByIdUseCase: GetBankByIdUseCase
) {

    @PostMapping
    fun create(@RequestBody @Valid request: AccountRequest) =
        ResponseEntity(
            createAccountUseCase.execute(
                Account(
                    request.description,
                    getBankByIdUseCase.execute(request.idbank)
                )
            ).toResponse(), HttpStatus.CREATED
        )
}