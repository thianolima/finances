package com.finances.infrastructure.entrypoint.exception

import com.finances.core.exception.EntityAlreadyExistsException
import com.finances.core.exception.EntityNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*
import javax.validation.ConstraintViolationException

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler(){

    @ExceptionHandler(EntityAlreadyExistsException::class)
    fun alreadyExists(ex: EntityAlreadyExistsException) : ResponseEntity<Any> =
        ResponseEntity(Response(ex.message!!), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(EntityNotFoundException::class)
    fun notFound(ex: EntityNotFoundException) : ResponseEntity<Any> =
        ResponseEntity(Response(ex.message!!), HttpStatus.NOT_FOUND)

    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> =
        handleExceptionInternal(
            ex,
            ex.bindingResult.fieldErrors.map{ Response("${it.field}: ${it.defaultMessage}") }.first(),
            headers,
            status,
            request
        )

    private data class Response(val message : String)
}