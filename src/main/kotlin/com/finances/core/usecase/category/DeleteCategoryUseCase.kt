package com.finances.core.usecase.category

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.exception.ExpenseUsingAccountException
import com.finances.core.repository.CategoryRepository
import com.finances.core.repository.ExpenseRepository

class DeleteCategoryUseCase(
    val categoryRepository: CategoryRepository,
    val expenseRepository: ExpenseRepository
) {
    val MSG_NOT_FOUND = "Categoria não encontrada!"
    val MSG_USING = "A Categoria esta sendo utilizado em uma ou mais despesas!"

    fun execute(id: String) =
        when (validate(id)) {
            true -> categoryRepository.delete(id)
            false -> throw ExpenseUsingAccountException(MSG_USING)
        }

    private fun validate(id: String) =
        when (categoryRepository.findById(id).isPresent) {
            true -> !expenseRepository.existsByCategoryId(id)
            false ->throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}