package com.customer.core.usecases.customer.impl

import com.customer.core.ports.gateways.CustomerGateway
import com.customer.core.usecases.customer.CustomerRegisterUseCase
import com.customer.domain.Customer
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CustomerRegisterUseCaseImpl(
    private val customerGateway: CustomerGateway
) : CustomerRegisterUseCase {
    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun execute(customer: Customer): Customer {
        log.info("Creating customer from request={}", customer)

        if (customerGateway.existsByName(customer.name)) {
            log.warn("Customer already registered")
            throw Exception("Customer already registered")
        }

        return customerGateway.save(customer)
    }
}