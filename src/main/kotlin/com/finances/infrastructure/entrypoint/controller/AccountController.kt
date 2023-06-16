package com.finances.infrastructure.entrypoint.controller

import com.finances.core.usecase.account.CreateAccountUseCase
import com.finances.core.usecase.account.DeleteAccountUseCase
import com.finances.core.usecase.account.FindAccountByIdUseCase
import com.finances.core.usecase.account.UpdateAccountUseCase
import com.finances.core.usecase.bank.FindBankByIdUseCase
import com.finances.infrastructure.mapper.toModel
import com.finances.infrastructure.mapper.toResponse
import com.finances.infrastructure.entrypoint.request.AccountRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/accounts")
class AccountController(
    val createAccountUseCase: CreateAccountUseCase,
    val findAccountByIdUseCase: FindAccountByIdUseCase,
    val getUpdateAccountUseCase: UpdateAccountUseCase,
    val deleteAccountUseCase: DeleteAccountUseCase,
    val findBankByIdUseCase: FindBankByIdUseCase
) {
    @PostMapping
    fun create(@RequestBody @Valid request: AccountRequest) =
        ResponseEntity(
            createAccountUseCase.execute(
                request.toModel(
                    findBankByIdUseCase.execute(request.idbank)
                )
            ).toResponse(), HttpStatus.CREATED
        )

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @Valid @RequestBody request: AccountRequest) =
        ResponseEntity(
            getUpdateAccountUseCase.execute(
                request.toModel(
                    id,
                    findBankByIdUseCase.execute(request.idbank)
                )
            ).toResponse(), HttpStatus.OK
        )

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) =
        ResponseEntity(findAccountByIdUseCase.execute(id).toResponse(), HttpStatus.OK)

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) =
        deleteAccountUseCase.execute(id)
}