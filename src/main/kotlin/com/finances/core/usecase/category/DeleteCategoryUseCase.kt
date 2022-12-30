package com.finances.core.usecase.category

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.repository.CategoryRepository

class DeleteCategoryUseCase(private val categoryRepository: CategoryRepository) {

    private val MSG_NOT_FOUND = "Categoria não encontrada!"

    fun execute(id: String) =
        when(categoryRepository.findById(id).isPresent){
            true -> categoryRepository.delete(id)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}