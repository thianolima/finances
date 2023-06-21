package com.finances.infrastructure.entrypoint.controller

import com.finances.core.usecase.account.FindAccountByIdUseCase
import com.finances.core.usecase.category.FindCategoryByIdUseCase
import com.finances.core.usecase.expense.*
import com.finances.infrastructure.entrypoint.request.ExpenseRequest
import com.finances.infrastructure.entrypoint.request.ExpenseSearchRequest
import com.finances.infrastructure.mapper.toModel
import com.finances.infrastructure.mapper.toResponse
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
    val findExpenseByBuyDateAndAmountUseCase: FindExpenseByBuyDateAndAmountUseCase,
    val findLastCategoryByExpenseDescriptionUseCase : FindLastCategoryByExpenseDescriptionUseCase
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
        ResponseEntity(findExpenseByBuyDateAndAmountUseCase.execute(
            expenseSearchRequest.buyDateParse!!, expenseSearchRequest.amount), HttpStatus.OK)

    @GetMapping("/lastcategory")
    fun lastCategory(@RequestParam description: String) =
        ResponseEntity(findLastCategoryByExpenseDescriptionUseCase.execute(description).toResponse(), HttpStatus.OK)

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