package com.amateo.java.examples.architectures.hexagonal.adapters.mysql;

import com.amateo.java.examples.architectures.hexagonal.adapters.mysql.entity.CustomerEntity;
import com.amateo.java.examples.architectures.hexagonal.domain.model.Customer;
import com.amateo.java.examples.architectures.hexagonal.domain.ports.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.amateo.java.examples.architectures.hexagonal.adapters.mysql.mapper.CustomerMapper.INSTANCE;

@Primary
@Component
@RequiredArgsConstructor
public class CustomerMysqlRepositoryImpl implements CustomerRepository {

    private final MysqlCustomerRepository repository;

    @Override
    public Optional<Customer> getCustomerById(final String customerId) {
        return repository.findById(Integer.valueOf(customerId))
                .map(INSTANCE::customerFrom);
    }

    @Override
    public Customer save(final Customer customer) {
        final CustomerEntity customerEntity = INSTANCE
                .customerEntityFrom(customer);

        return INSTANCE.customerFrom(
                repository.save(customerEntity));
    }

}
