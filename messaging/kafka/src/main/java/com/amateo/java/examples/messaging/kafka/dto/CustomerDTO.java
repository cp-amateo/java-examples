package com.amateo.java.examples.messaging.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String email;

}
