package com.finances.infrastructure.entrypoint.exception

import com.finances.core.exception.*
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(EntityAlreadyExistsException::class)
    fun alreadyExists(ex: EntityAlreadyExistsException) =
        ResponseEntity(Response(ex.message!!), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(EntityNotFoundException::class)
    fun notFound(ex: EntityNotFoundException) =
        ResponseEntity(Response(ex.message!!), HttpStatus.NOT_FOUND)

    @ExceptionHandler(AccountUsingBankException::class)
    fun accountUsingBank(ex: AccountUsingBankException) =
        ResponseEntity(Response(ex.message!!), HttpStatus.UNAUTHORIZED)

    @ExceptionHandler(ExpenseUsingAccountException::class)
    fun expenseUsingAccount(ex: ExpenseUsingAccountException) =
        ResponseEntity(Response(ex.message!!), HttpStatus.UNAUTHORIZED)

    @ExceptionHandler(DomainException::class)
    fun domain(ex: DomainException) =
        ResponseEntity(Response(ex.message!!), HttpStatus.UNAUTHORIZED)


    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> =
        handleExceptionInternal(
            ex,
            ex.bindingResult.fieldErrors.map { Response("${it.field}: ${it.defaultMessage}") }.first(),
            headers,
            status,
            request
        )

    data class Response(val message: String)
}