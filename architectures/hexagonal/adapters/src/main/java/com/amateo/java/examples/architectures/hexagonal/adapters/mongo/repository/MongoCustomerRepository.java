package com.amateo.java.examples.architectures.hexagonal.adapters.mongo.repository;

import com.amateo.java.examples.architectures.hexagonal.adapters.mongo.document.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoCustomerRepository extends MongoRepository<CustomerDocument, String> {
}
