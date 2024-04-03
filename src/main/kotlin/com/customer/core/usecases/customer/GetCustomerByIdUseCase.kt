package com.customer.core.usecases.customer

import com.customer.domain.Customer

interface GetCustomerByIdUseCase {
    fun execute(id: String): Customer?
}