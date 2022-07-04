package com.amateo.java.examples.architectures.hexagonal.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@EqualsAndHashCode
public class Customer {

    private Integer id;
    private String name;
    private String surnames;
    private LocalDate dob;

}
