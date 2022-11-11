package com.finances.infrastructure.entrypoint.controller

import com.finances.core.model.Category
import com.finances.core.usecase.CreateCategoryUseCase
import com.finances.core.usecase.DeleteCategoryUseCase
import com.finances.core.usecase.GetCategoryByIdUseCase
import com.finances.core.usecase.UpdateCategoryUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/categories")
class CategoryController(
    val saveCategoryUseCase : CreateCategoryUseCase,
    val deleteCategoryUseCase : DeleteCategoryUseCase,
    val updateCategoryUseCase : UpdateCategoryUseCase,
    val getCategoryByIdUseCase: GetCategoryByIdUseCase
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@Valid @RequestBody request : Request) =
        saveCategoryUseCase.execute(Category(UUID.randomUUID().toString(), request.name))

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id : String) =
        deleteCategoryUseCase.execute(id)

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    fun update(@PathVariable id : String, @Valid @RequestBody request : Request) =
        updateCategoryUseCase.execute(Category(id, request.name))

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    fun update(@PathVariable id : String) =
        getCategoryByIdUseCase.execute(id)

    data class Request (@field:NotBlank val name : String)

    data class Response (val id : String , val name : String)
}
