package com.amateo.java.examples.architectures.hexagonal.adapters.mongo.repository;

import com.amateo.java.examples.architectures.hexagonal.adapters.mongo.document.CustomerDocument;
import com.amateo.java.examples.architectures.hexagonal.adapters.mongo.mapper.CustomerMapper;
import com.amateo.java.examples.architectures.hexagonal.domain.model.Customer;
import com.amateo.java.examples.architectures.hexagonal.domain.ports.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final MongoCustomerRepository repository;

    @Override
    public Optional<Customer> getCustomerById(final String customerId) {
        return repository.findById(customerId)
                .map(CustomerMapper.INSTANCE::customerFrom);
    }

    @Override
    public Customer save(final Customer customer) {
        final CustomerDocument customerDocument = CustomerMapper.INSTANCE
                .customerDocumentFrom(customer);

        return CustomerMapper.INSTANCE.customerFrom(
                repository.save(customerDocument));
    }

}
