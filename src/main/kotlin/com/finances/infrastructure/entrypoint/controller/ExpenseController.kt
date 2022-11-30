package com.finances.infrastructure.entrypoint.controller

import com.finances.core.usecase.account.GetAccountByIdUseCase
import com.finances.core.usecase.category.GetCategoryByIdUseCase
import com.finances.core.usecase.expense.CreateExpenseUseCase
import com.finances.infrastructure.dataprovider.mapper.toModel
import com.finances.infrastructure.dataprovider.mapper.toResponse
import com.finances.infrastructure.entrypoint.dto.input.ExpenseRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/expenses")
class ExpenseController(
    val createExpenseUseCase: CreateExpenseUseCase,
    val getAccountByIdUseCase: GetAccountByIdUseCase,
    val getCategoryByIdUseCase: GetCategoryByIdUseCase
) {
    @PostMapping
    fun create(@RequestBody @Valid request: ExpenseRequest) =
        ResponseEntity(
            createExpenseUseCase.execute(
                request.toModel(
                    getCategoryByIdUseCase.execute(request.idcategory),
                    getAccountByIdUseCase.execute(request.idaccount)
                )
            ).toResponse(), HttpStatus.CREATED
        )
}