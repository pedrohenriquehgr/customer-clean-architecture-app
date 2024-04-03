package com.customer.infrastructure.adapters.persistence.mongodb.repositories

import com.customer.infrastructure.adapters.persistence.mongodb.models.CustomerDocumentModel
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository : MongoRepository<CustomerDocumentModel, ObjectId> {
    fun existsByName(name: String): Boolean
}
