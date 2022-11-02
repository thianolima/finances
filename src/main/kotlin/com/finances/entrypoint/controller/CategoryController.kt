package com.finances.entrypoint.controller

import com.finances.core.model.Category
import com.finances.entrypoint.request.CategoryRequest
import com.finances.core.usecase.SaveCategoryUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/categories")
class CategoryController(open val saveCategoryUseCase : SaveCategoryUseCase) {

    @PostMapping
    fun create(@RequestBody request : CategoryRequest) =
        saveCategoryUseCase.execute(Category(UUID.randomUUID(), request.name))
}
