package com.finances

import com.fasterxml.jackson.databind.ObjectMapper
import com.finances.infrastructure.entrypoint.dto.input.BankRequest
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.Test

class BankControllerTest {

    @Test
    fun `01 - Deve inserir um novo Banco`(){
        val request = BankRequest("001", "BRASIL")

        Given {
            spec(requestSpecification())
            body(request)
        }When {
            post("/banks")
        }Then {
            statusCode(201)
        }
    }

    fun requestSpecification(): RequestSpecification {
        return RequestSpecBuilder()
            .setBaseUri("http://localhost:8080")
            .addHeader("Accept", "application/json")
            .setContentType(ContentType.JSON)
            .setRelaxedHTTPSValidation()
            .build()
    }
}