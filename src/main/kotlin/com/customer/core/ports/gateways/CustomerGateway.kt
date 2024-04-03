package com.customer.core.ports.gateways

import com.customer.domain.Customer
import org.springframework.stereotype.Component

@Component
interface CustomerGateway {
    fun existsByName(name: String): Boolean
    fun save(customer: Customer): Customer
    fun getById(id: String): Customer?

}