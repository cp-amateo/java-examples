package com.amateo.java.examples.messaging.kafka.agents.producer;

import com.amateo.java.examples.messaging.kafka.event.CustomerEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerEventProducerShould {

    private static final String TOPIC = "some-topic";
    private static final String ID = "1234FTG";
    private static final String FIRST_NAME = "Alejandro";
    private static final String LAST_NAME = "Mateo";
    private static final String EMAIL = "amateo@test.com";

    @Mock
    private KafkaTemplate<String, CustomerEvent> kafkaTemplate;

    @InjectMocks
    private CustomerEventProducer customerEventProducer;

    @BeforeEach
    void setUp() {
        customerEventProducer = new CustomerEventProducer(kafkaTemplate, TOPIC);
    }

    @Test
    void sendEvent_receivedValidEvent_sendEventToKafka() {
        final var customerEvent = CustomerEvent.newBuilder()
                .setId(ID)
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .build();

        customerEventProducer.sendEvent(customerEvent);

        verify(kafkaTemplate).send(TOPIC, ID, customerEvent);
    }
}