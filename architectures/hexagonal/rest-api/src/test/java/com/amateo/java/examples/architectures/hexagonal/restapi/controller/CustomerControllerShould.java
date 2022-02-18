package com.amateo.java.examples.architectures.hexagonal.restapi.controller;

import com.amateo.java.examples.architectures.hexagonal.domain.model.Customer;
import com.amateo.java.examples.architectures.hexagonal.domain.service.CustomerService;
import com.amateo.java.examples.architectures.hexagonal.restapi.dto.CustomerDTO;
import com.amateo.java.examples.architectures.hexagonal.restapi.dto.CustomerIdDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerShould {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAMES = "surnames";
    private static final LocalDate DOB = LocalDate.now();

    @Mock
    CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    void getCustomer_customerExist_returnCustomerData() {
        when(customerService.findCustomerById(ID)).thenReturn(getCustomer());

        ResponseEntity<CustomerDTO> response = customerController.getCustomer(ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(getCustomerDTO());
    }

    @Test
    void createCustomer_createNewCustomer_returnCustomerID() {
        when(customerService.createCustomer(getCustomer())).thenReturn(getCustomer());

        ResponseEntity<CustomerIdDTO> response = customerController.createCustomer(getCustomerDTO());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getId()).isEqualTo(ID);
    }

    private Customer getCustomer() {
        return Customer.builder()
                .id(ID)
                .name(NAME)
                .surnames(SURNAMES)
                .dob(DOB)
                .build();
    }

    private CustomerDTO getCustomerDTO() {
        return CustomerDTO.builder()
                .id(ID)
                .name(NAME)
                .surnames(SURNAMES)
                .dob(DOB)
                .build();
    }
}