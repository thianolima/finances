package com.finances.core.usecase

import com.finances.core.exception.EntityNotFoundException
import com.finances.core.gateway.CategoryGateway

class DeleteCategoryUseCase (private val categoryGateway : CategoryGateway){
    private val MSG_NOT_FOUND = "Categoria não encontrada!"

    fun execute(id : String) =
        when(categoryGateway.findById(id).isPresent){
            true -> categoryGateway.delete(id)
            false -> throw EntityNotFoundException(MSG_NOT_FOUND)
        }
}