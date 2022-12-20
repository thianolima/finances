package com.finances.infrastructure.entrypoint.controller

import com.finances.core.model.Category
import com.finances.core.usecase.category.CreateCategoryUseCase
import com.finances.core.usecase.category.DeleteCategoryUseCase
import com.finances.core.usecase.category.GetCategoryByIdUseCase
import com.finances.core.usecase.category.UpdateCategoryUseCase
import com.finances.infrastructure.mapper.toResponse
import com.finances.infrastructure.entrypoint.dto.input.CategoryRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/categories")
class CategoryController(
    val createUseCase: CreateCategoryUseCase,
    val deleteUseCase: DeleteCategoryUseCase,
    val updateUseCase: UpdateCategoryUseCase,
    val getByIdUseCase: GetCategoryByIdUseCase
) {
    @PostMapping
    fun create(@Valid @RequestBody request: CategoryRequest) =
        ResponseEntity(
            createUseCase.execute(
                Category(request.name)
            ).toResponse(), HttpStatus.CREATED
        )

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) =
        deleteUseCase.execute(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @Valid @RequestBody request: CategoryRequest) =
        ResponseEntity(updateUseCase.execute(Category(id, request.name)).toResponse(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) =
        ResponseEntity(getByIdUseCase.execute(id).toResponse(), HttpStatus.OK)
}
