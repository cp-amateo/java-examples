package com.amateo.java.examples.architectures.hexagonal.adapters.mongo.mapper;

import com.amateo.java.examples.architectures.hexagonal.adapters.mongo.document.CustomerDocument;
import com.amateo.java.examples.architectures.hexagonal.domain.model.Customer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerMapperShould {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAMES = "surnames";
    private static final LocalDate DOB = LocalDate.now();

    @Test
    void customerDocumentFrom_mapper_returnCustomerDocument() {
        assertThat(CustomerMapper.INSTANCE.customerDocumentFrom(getCustomer()))
                .isEqualTo(getCustomerDocument());
    }

    @Test
    void customerFrom_mapper_returnCustomer() {
        assertThat(CustomerMapper.INSTANCE.customerFrom(getCustomerDocument()))
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

    private CustomerDocument getCustomerDocument() {
        return CustomerDocument.builder()
                .id(ID)
                .name(NAME)
                .surnames(SURNAMES)
                .dob(DOB)
                .build();
    }

}