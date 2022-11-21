package com.finances.infrastructure.entrypoint.controller

import com.finances.core.model.Category
import com.finances.core.usecase.category.CreateCategoryUseCase
import com.finances.core.usecase.category.DeleteCategoryUseCase
import com.finances.core.usecase.category.GetCategoryByIdUseCase
import com.finances.core.usecase.category.UpdateCategoryUseCase
import com.finances.infrastructure.dataprovider.mapper.toResponse
import com.finances.infrastructure.entrypoint.dto.input.CategoryRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/categories")
class CategoryController(
    val createCategoryUseCase: CreateCategoryUseCase,
    val deleteCategoryUseCase: DeleteCategoryUseCase,
    val updateCategoryUseCase: UpdateCategoryUseCase,
    val getCategoryByIdUseCase: GetCategoryByIdUseCase
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@Valid @RequestBody request: CategoryRequest) =
        createCategoryUseCase.execute(Category(request.name)).toResponse()

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) =
        deleteCategoryUseCase.execute(id)

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @Valid @RequestBody request: CategoryRequest) =
        updateCategoryUseCase.execute(Category(id, request.name)).toResponse()

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) =
        getCategoryByIdUseCase.execute(id).toResponse()
}
