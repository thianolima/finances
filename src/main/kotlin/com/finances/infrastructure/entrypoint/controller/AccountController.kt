package com.finances.infrastructure.entrypoint.controller

import com.finances.core.model.Account
import com.finances.core.usecase.account.CreateAccountUseCase
import com.finances.core.usecase.account.DeleteAccountUseCase
import com.finances.core.usecase.account.GetAccountByIdUseCase
import com.finances.core.usecase.account.UpdateAccountUseCase
import com.finances.core.usecase.bank.GetBankByIdUseCase
import com.finances.infrastructure.dataprovider.mapper.toResponse
import com.finances.infrastructure.entrypoint.dto.input.AccountRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/accounts")
class AccountController(
    val createAccountUseCase: CreateAccountUseCase,
    val getAccountByIdUseCase: GetAccountByIdUseCase,
    val getUpdateAccountUseCase: UpdateAccountUseCase,
    val deleteAccountUseCase: DeleteAccountUseCase,
    val getBankByIdUseCase: GetBankByIdUseCase
) {
    @PostMapping
    fun create(@RequestBody @Valid request: AccountRequest) =
        ResponseEntity(
            createAccountUseCase.execute(
                Account(
                    description = request.description,
                    bank = getBankByIdUseCase.execute(request.idbank)
                )
            ).toResponse(), HttpStatus.CREATED
        )

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @Valid @RequestBody request: AccountRequest) =
        ResponseEntity(
            getUpdateAccountUseCase.execute(
                Account(
                    id = id,
                    description = request.description,
                    bank = getBankByIdUseCase.execute(request.idbank)
                )
            ).toResponse(), HttpStatus.OK
        )

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) =
        ResponseEntity(getAccountByIdUseCase.execute(id).toResponse(), HttpStatus.OK)

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) =
        deleteAccountUseCase.execute(id)
}