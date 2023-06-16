package com.finances.infrastructure.entrypoint.controller

import com.finances.core.usecase.account.FindAccountByIdUseCase
import com.finances.core.usecase.category.FindCategoryByIdUseCase
import com.finances.core.usecase.expense.CreateExpenseUseCase
import com.finances.core.usecase.expense.FindExpenseByBuyDateAndAmountUseCase
import com.finances.core.usecase.expense.FindExpenseByIdUseCase
import com.finances.core.usecase.expense.UpdateExpenseUseCase
import com.finances.infrastructure.mapper.toModel
import com.finances.infrastructure.mapper.toResponse
import com.finances.infrastructure.entrypoint.request.ExpenseRequest
import com.finances.infrastructure.entrypoint.request.ExpenseSearchRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/expenses")
class ExpenseController(
    val createExpenseUseCase: CreateExpenseUseCase,
    val findExpenseUseCase: FindExpenseByIdUseCase,
    val updateExpenseUseCase: UpdateExpenseUseCase,
    val findAccountByIdUseCase: FindAccountByIdUseCase,
    val findCategoryByIdUseCase: FindCategoryByIdUseCase,
    val finfExpenseByBuyDateAndAmountUseCase: FindExpenseByBuyDateAndAmountUseCase
) {
    @PostMapping
    fun create(@RequestBody @Valid request: ExpenseRequest) =
        ResponseEntity(
            createExpenseUseCase.execute(
                request.toModel(
                    findCategoryByIdUseCase.execute(request.idcategory),
                    findAccountByIdUseCase.execute(request.idaccount)
                )
            ).toResponse(), HttpStatus.CREATED
        )

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) =
        ResponseEntity(findExpenseUseCase.execute(id).toResponse(), HttpStatus.OK)

    @GetMapping("/search")
    fun search(@Valid expenseSearchRequest: ExpenseSearchRequest) =
        ResponseEntity(finfExpenseByBuyDateAndAmountUseCase.execute(
            expenseSearchRequest.buyDateParse!!, expenseSearchRequest.amount), HttpStatus.OK)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @Valid @RequestBody request: ExpenseRequest) =
        ResponseEntity(
            updateExpenseUseCase.execute(
                request.toModel(
                    id,
                    findCategoryByIdUseCase.execute(request.idcategory),
                    findAccountByIdUseCase.execute(request.idaccount)
                )
            ).toResponse(), HttpStatus.CREATED
        )
}