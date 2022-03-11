package com.amateo.java.examples.messaging.kafka.restapi.controller;

import com.amateo.java.examples.messaging.kafka.agents.producer.CustomerEventProducer;
import com.amateo.java.examples.messaging.kafka.event.CustomerEvent;
import com.amateo.java.examples.messaging.kafka.restapi.dto.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerCreationControllerShould {

    private static final String FIRST_NAME = "Alejandro";
    private static final String LAST_NAME = "Mateo";
    private static final String EMAIL = "amateo@test.com";

    @Mock
    private CustomerEventProducer customerEventProducer;

    @InjectMocks
    private CustomerCreationController customerCreationController;

    @Captor
    private ArgumentCaptor<CustomerEvent> customerEventArgumentCaptor;

    @Test
    void createCustomer_receivedValidBody_callGenerateEvent() {
        final var customerDTO = CustomerDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .build();

        customerCreationController.createCustomer(customerDTO);

        verify(customerEventProducer).sendEvent(customerEventArgumentCaptor.capture());

        final var customerEvent = customerEventArgumentCaptor.getValue();
        assertThat(customerEvent.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(customerEvent.getLastName()).isEqualTo(LAST_NAME);
        assertThat(customerEvent.getEmail()).isEqualTo(EMAIL);
    }
}