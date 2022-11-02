package com.finances.entrypoint.exception

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.entrypoint.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler(){

    @ExceptionHandler(EntityAlreadyExistsException::class)
    fun alreadyExists(ex: EntityAlreadyExistsException) =
        ResponseEntity(ErrorResponse(ex.message!!), HttpStatus.BAD_REQUEST)
}