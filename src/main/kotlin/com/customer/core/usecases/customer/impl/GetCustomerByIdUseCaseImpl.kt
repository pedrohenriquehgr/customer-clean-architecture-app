package com.customer.core.usecases.customer.impl

import com.customer.core.ports.gateways.CustomerGateway
import com.customer.core.usecases.customer.GetCustomerByIdUseCase
import com.customer.domain.Customer
import org.springframework.stereotype.Service

@Service
class GetCustomerByIdUseCaseImpl(
    private val customerGateway: CustomerGateway
) : GetCustomerByIdUseCase {

    override fun execute(id: String): Customer? {
        return customerGateway.getById(id)
    }
}