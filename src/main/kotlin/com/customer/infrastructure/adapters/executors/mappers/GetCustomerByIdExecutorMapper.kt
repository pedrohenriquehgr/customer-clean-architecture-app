package com.customer.infrastructure.adapters.executors.mappers

import com.customer.domain.Customer
import com.customer.infrastructure.adapters.executors.dto.CustomerRegisterRequest
import com.customer.infrastructure.adapters.executors.dto.CustomerRegisterResponse
import com.customer.infrastructure.adapters.executors.dto.GetCustomerByIdResponse
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface GetCustomerByIdExecutorMapper {
    fun toResponse(customer: Customer): GetCustomerByIdResponse
}