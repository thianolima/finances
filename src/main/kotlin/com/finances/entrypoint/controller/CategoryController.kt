package com.finances.entrypoint.controller

import com.finances.core.model.Category
import com.finances.core.usecase.CreateCategoryUseCase
import com.finances.core.usecase.DeleteCategoryUseCase
import com.finances.entrypoint.request.CategoryRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/categories")
class CategoryController(
    val saveCategoryUseCase : CreateCategoryUseCase,
    val deleteCategoryUseCase : DeleteCategoryUseCase) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@RequestBody request : CategoryRequest) =
        saveCategoryUseCase.execute(Category(UUID.randomUUID().toString(), request.name))

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id : String) =
        deleteCategoryUseCase.execute(id)

}
