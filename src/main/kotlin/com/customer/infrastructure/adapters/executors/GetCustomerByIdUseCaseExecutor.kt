package com.customer.infrastructure.adapters.executors

import com.customer.core.usecases.customer.GetCustomerByIdUseCase
import com.customer.infrastructure.adapters.executors.mappers.GetCustomerByIdExecutorMapper
import com.customer.infrastructure.adapters.executors.dto.GetCustomerByIdResponse
import org.springframework.stereotype.Component

@Component
class GetCustomerByIdUseCaseExecutor(
    private val getCustomerByIdUseCase: GetCustomerByIdUseCase,
    private val getCustomerByIdExecutorMapper: GetCustomerByIdExecutorMapper
) {

    fun execute(id: String): GetCustomerByIdResponse? {
        val customer = getCustomerByIdUseCase.execute(id)
        return customer?.let { getCustomerByIdExecutorMapper.toResponse(it) }
    }
}