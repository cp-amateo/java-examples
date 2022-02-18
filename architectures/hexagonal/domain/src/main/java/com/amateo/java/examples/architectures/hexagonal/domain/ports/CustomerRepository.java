package com.amateo.java.examples.architectures.hexagonal.domain.ports;

import com.amateo.java.examples.architectures.hexagonal.domain.model.Customer;

import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> getCustomerById(String customerId);

    Customer save(Customer customer);
}
