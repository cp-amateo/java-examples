package com.amateo.java.examples.architectures.hexagonal.domain.service;

import com.amateo.java.examples.architectures.hexagonal.domain.exception.CustomerException;
import com.amateo.java.examples.architectures.hexagonal.domain.exception.ErrorCode;
import com.amateo.java.examples.architectures.hexagonal.domain.model.Customer;
import com.amateo.java.examples.architectures.hexagonal.domain.ports.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceShould {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAMES = "surnames";
    private static final LocalDate DOB = LocalDate.now();

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void findCustomerById_customerDontExist_throwException() {
        when(customerRepository.getCustomerById(any()))
                .thenThrow(new CustomerException(ErrorCode.ENTITY_NOT_FOUND, "Consumer id not found."));

        var exception = assertThrows(CustomerException.class, () -> customerService.findCustomerById(any()));
        assertThat(exception.getErrorCode()).isEqualTo(ErrorCode.ENTITY_NOT_FOUND);
    }

    @Test
    void findCustomerById_customerExist_returnCustomerData() {
        when(customerRepository.getCustomerById(ID))
                .thenReturn(Optional.of(getCustomer()));

        final var customer = customerService.findCustomerById(ID);

        assertThat(customer).isEqualTo(getCustomer());
    }

    @Test
    void createCustomer_newCustomer_returnCustomerData() {
        final var customer = getCustomer();
        customerService.createCustomer(customer);

        verify(customerRepository).save(customer);
    }

    private Customer getCustomer() {
        return Customer.builder()
                .id(ID)
                .name(NAME)
                .surnames(SURNAMES)
                .dob(DOB)
                .build();
    }
}