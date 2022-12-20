package com.finances.infrastructure.entrypoint.controller

import com.finances.core.usecase.account.GetAccountByIdUseCase
import com.finances.core.usecase.category.GetCategoryByIdUseCase
import com.finances.core.usecase.expense.CreateExpenseUseCase
import com.finances.core.usecase.expense.GetExpenseByIdUseCase
import com.finances.core.usecase.expense.UpdateExpenseUseCase
import com.finances.infrastructure.mapper.toModel
import com.finances.infrastructure.mapper.toResponse
import com.finances.infrastructure.entrypoint.dto.input.ExpenseRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/expenses")
class ExpenseController(
    val createExpenseUseCase: CreateExpenseUseCase,
    val getExpenseUseCase: GetExpenseByIdUseCase,
    val updateExpenseUseCase: UpdateExpenseUseCase,
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

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) =
        ResponseEntity(getExpenseUseCase.execute(id).toResponse(), HttpStatus.OK)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @Valid @RequestBody request: ExpenseRequest) =
        ResponseEntity(
            updateExpenseUseCase.execute(
                request.toModel(
                    id,
                    getCategoryByIdUseCase.execute(request.idcategory),
                    getAccountByIdUseCase.execute(request.idaccount)
                )
            ).toResponse(), HttpStatus.CREATED
        )
}