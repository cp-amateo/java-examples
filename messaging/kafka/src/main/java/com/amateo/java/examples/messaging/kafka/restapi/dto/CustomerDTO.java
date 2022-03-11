package com.amateo.java.examples.messaging.kafka.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String email;

}
