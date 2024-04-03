package com.customer.infrastructure.adapters.persistence.mongodb.mappers

import com.customer.domain.Customer
import com.customer.infrastructure.adapters.persistence.mongodb.models.CustomerDocumentModel
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CustomerDocumentModelMapper {
    fun toDomain(customerDocumentModel: CustomerDocumentModel): Customer
    fun toEntity(customer: Customer): CustomerDocumentModel
}