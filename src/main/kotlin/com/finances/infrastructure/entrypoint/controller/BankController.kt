package com.finances.infrastructure.entrypoint.controller

import com.finances.core.model.Bank
import com.finances.core.usecase.bank.CreateBankUseCase
import com.finances.core.usecase.bank.DeleteBankUseCase
import com.finances.core.usecase.bank.GetBankByIdUseCase
import com.finances.core.usecase.bank.UpdateBankUseCase
import com.finances.infrastructure.dataprovider.mapper.toResponse
import com.finances.infrastructure.entrypoint.dto.input.BankRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/banks")
class BankController(
    val createUseCase: CreateBankUseCase,
    val deleteUseCase: DeleteBankUseCase,
    val updateUseCase: UpdateBankUseCase,
    val getByIdUseCase: GetBankByIdUseCase
) {
    @PostMapping
    fun create(@Valid @RequestBody request: BankRequest) =
        ResponseEntity(createUseCase.execute(Bank(request.code, request.name)).toResponse(), HttpStatus.CREATED)

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) =
        deleteUseCase.execute(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @Valid @RequestBody request: BankRequest) =
        ResponseEntity(updateUseCase.execute(Bank(id, request.code, request.name)).toResponse(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) =
        ResponseEntity(getByIdUseCase.execute(id).toResponse(), HttpStatus.OK)
}