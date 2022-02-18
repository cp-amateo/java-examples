package com.amateo.java.examples.architectures.hexagonal.domain.service;

import com.amateo.java.examples.architectures.hexagonal.domain.exception.CustomerException;
import com.amateo.java.examples.architectures.hexagonal.domain.exception.ErrorCode;
import com.amateo.java.examples.architectures.hexagonal.domain.model.Customer;
import com.amateo.java.examples.architectures.hexagonal.domain.ports.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer findCustomerById(final String customerId) {
        return customerRepository.getCustomerById(customerId)
                .orElseThrow(() -> new CustomerException(
                        ErrorCode.ENTITY_NOT_FOUND,
                        String.format("Consumer id %s not found.", customerId)));
    }

    public Customer createCustomer(final Customer customer) {
        return customerRepository.save(customer);
    }
}
