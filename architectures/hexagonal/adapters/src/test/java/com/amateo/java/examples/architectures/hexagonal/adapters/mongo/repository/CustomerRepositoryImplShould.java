package com.amateo.java.examples.architectures.hexagonal.adapters.mongo.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerRepositoryImplShould {

    @Mock
    MongoCustomerRepository repository;

    @InjectMocks
    private CustomerRepositoryImpl customerRepository;

    @Test
    void getCustomerById_findCustomerId_returnCustomerOp() {
        customerRepository.getCustomerById(any());

        verify(repository).findById(any());
    }

    @Test
    void save_storeCustomerData_returnCustomer() {
        customerRepository.save(any());

        verify(repository).save(any());
    }
}