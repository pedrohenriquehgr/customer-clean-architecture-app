package com.customer.infrastructure.adapters.executors

import com.customer.core.usecases.customer.CustomerRegisterUseCase
import com.customer.infrastructure.adapters.executors.mappers.CustomerRegisterExecutorMapper
import com.customer.infrastructure.adapters.rest.dto.CustomerRegisterRequest
import com.customer.infrastructure.adapters.rest.dto.CustomerRegisterResponse
import org.springframework.stereotype.Component

@Component
class CustomerRegisterUseCaseExecutor(
    private val customerRegisterUseCase: CustomerRegisterUseCase,
    private val customerRegisterExecutorMapper: CustomerRegisterExecutorMapper
) {

    fun execute(customerRequest: CustomerRegisterRequest): CustomerRegisterResponse {
        val customer = customerRegisterExecutorMapper.toDomain(customerRequest)
        val customerRegistered = customerRegisterUseCase.execute(customer)
        return customerRegisterExecutorMapper.toResponse(customerRegistered)
    }
}