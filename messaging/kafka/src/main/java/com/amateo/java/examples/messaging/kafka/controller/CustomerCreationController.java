package com.amateo.java.examples.messaging.kafka.controller;

import com.amateo.java.examples.messaging.kafka.dto.CustomerDTO;
import com.amateo.java.examples.messaging.kafka.event.CustomerEvent;
import com.amateo.java.examples.messaging.kafka.producer.CustomerEventProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

@RestController
@RequestMapping("customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerCreationController {

    private final CustomerEventProducer customerEventProducer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(
            @RequestBody final CustomerDTO customerDTO) {

        customerEventProducer.sendEvent(CustomerEvent.newBuilder()
                .setId(getRandomString())
                .setFirstName(customerDTO.getFirstName())
                .setLastName(customerDTO.getLastName())
                .setEmail(customerDTO.getEmail())
                .build());
    }

    private String getRandomString() {
        return String.valueOf(
                new SecureRandom().longs(80_010_000_000L, 100_000_000_000L)
                        .findFirst().getAsLong());
    }

}
