package com.customer.infrastructure.adapters.persistence.mongodb.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("customer")
data class CustomerDocumentModel(
    @Id var id: String? = null,
    val name: String
)