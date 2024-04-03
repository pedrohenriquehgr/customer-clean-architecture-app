package com.customer.infrastructure.adapters.rest.controllers

import com.customer.infrastructure.adapters.executors.CustomerRegisterUseCaseExecutor
import com.customer.infrastructure.adapters.executors.GetCustomerByIdUseCaseExecutor
import com.customer.infrastructure.adapters.rest.dto.CustomerRegisterRequest
import com.customer.infrastructure.adapters.rest.dto.CustomerRegisterResponse
import com.customer.infrastructure.adapters.rest.dto.GetCustomerByIdResponse
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/customers")
class CustomerController(
    private val customerRegisterUseCaseExecutor: CustomerRegisterUseCaseExecutor,
    private val getCustomerByIdUseCaseExecutor: GetCustomerByIdUseCaseExecutor
) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @PostMapping
    fun customerRegister(@RequestBody customerRegisterRequest: CustomerRegisterRequest): ResponseEntity<CustomerRegisterResponse> {
        try {
            val customerRegisterResponse =
                customerRegisterUseCaseExecutor.execute(customerRegisterRequest)

            log.info("Customer created response={}", customerRegisterResponse)

            return created(URI.create("/customers/${customerRegisterResponse.id}"))
                .body(customerRegisterResponse)
        } catch (e: Throwable) {
            return badRequest().build()
        }
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: String): ResponseEntity<GetCustomerByIdResponse> {
        val getCustomerByIdResponse =
            getCustomerByIdUseCaseExecutor.execute(id) ?: return notFound().build()
        return ok(getCustomerByIdResponse)
    }

}