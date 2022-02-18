package com.amateo.java.examples.architectures.hexagonal.restapi.mapper;

import com.amateo.java.examples.architectures.hexagonal.domain.model.Customer;
import com.amateo.java.examples.architectures.hexagonal.restapi.dto.CustomerDTO;
import com.amateo.java.examples.architectures.hexagonal.restapi.dto.CustomerIdDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerMapperShould {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAMES = "surnames";
    private static final LocalDate DOB = LocalDate.now();

    @Test
    void customerDTOFrom_mapping_returnCustomerDTO() {
        assertThat(CustomerMapper.INSTANCE.customerDTOFrom(getCustomer()))
                .isEqualTo(getCustomerDTO());
    }

    @Test
    void customerIdDTOFrom_mapping_returnCustomerIdDTO() {
        final CustomerIdDTO customerIdDTO = CustomerMapper.INSTANCE.customerIdDTOFrom(getCustomer());
        assertThat(customerIdDTO.getId())
                .isEqualTo(ID);
    }

    @Test
    void customerFrom_mapping_returnCustomer() {
        assertThat(CustomerMapper.INSTANCE.customerFrom(getCustomerDTO()))
                .isEqualTo(getCustomer());
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