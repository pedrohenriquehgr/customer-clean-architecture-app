package com.customer.infrastructure.adapters.executors.mappers

import com.customer.domain.Customer
import com.customer.infrastructure.adapters.rest.dto.CustomerRegisterRequest
import com.customer.infrastructure.adapters.rest.dto.CustomerRegisterResponse
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CustomerRegisterExecutorMapper {
    fun toDomain(customerRegisterRequest: CustomerRegisterRequest): Customer
    fun toResponse(customer: Customer): CustomerRegisterResponse
}