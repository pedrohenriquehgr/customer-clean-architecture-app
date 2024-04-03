package com.customer.infrastructure.adapters.gateways

import com.customer.core.ports.gateways.CustomerGateway
import com.customer.domain.Customer
import com.customer.infrastructure.adapters.persistence.mongodb.mappers.CustomerDocumentModelMapper
import com.customer.infrastructure.adapters.persistence.mongodb.repositories.CustomerRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class CustomerGatewayImpl(
    private val customerRepository: CustomerRepository,
    private val customerDocumentModelMapper: CustomerDocumentModelMapper
) : CustomerGateway {
    override fun existsByName(name: String): Boolean {
        return customerRepository.existsByName(name)
    }

    override fun getById(id: String): Customer? {
        val customerDocument = customerRepository.findById(ObjectId(id)).orElse(null)
        return customerDocument?.let { customerDocumentModelMapper.toDomain(it) }
    }

    override fun save(customer: Customer): Customer {
        val customerDocument = customerRepository.save(customerDocumentModelMapper.toEntity(customer))
        val customerSaved = customerDocumentModelMapper.toDomain(customerDocument)
        return customerSaved
    }
}