package com.amateo.java.examples.messaging.kafka.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Topic {
    CUSTOMER_CREATION("customer-creation-topic");

    private final String topic;

}
