package com.customer.infrastructure.adapters.rest.controllers

import com.customer.infrastructure.adapters.executors.dto.CustomerRegisterResponse
import com.customer.infrastructure.test.AbstractIT
import com.customer.infrastructure.test.JsonPayloadLoader
import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class CustomerControllerIT : AbstractIT() {
    @Test
    fun `customer register with success`() {
        val jsonObject = JsonPayloadLoader.load("customer/customer-register-request-with-success.json")

        val customerRegisterResponse = Given {
            log().all()
            contentType(ContentType.JSON)
            body(jsonObject.toString())
        } When {
            post("/customers")
        } Then {
            statusCode(201)
        } Extract {
            body().`as`(CustomerRegisterResponse::class.java)
        }

        assertNotNull(customerRegisterResponse.id)
        assertEquals(jsonObject.get("name"), customerRegisterResponse.name)
    }
}