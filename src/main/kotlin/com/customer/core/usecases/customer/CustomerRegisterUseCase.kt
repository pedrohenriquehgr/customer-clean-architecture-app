package com.customer.core.usecases.customer

import com.customer.domain.Customer

interface CustomerRegisterUseCase {
    fun execute(customer: Customer) : Customer
}