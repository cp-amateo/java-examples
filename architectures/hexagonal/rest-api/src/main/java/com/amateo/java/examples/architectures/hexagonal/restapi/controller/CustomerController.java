package com.amateo.java.examples.architectures.hexagonal.restapi.controller;

import com.amateo.java.examples.architectures.hexagonal.domain.model.Customer;
import com.amateo.java.examples.architectures.hexagonal.restapi.dto.response.CustomerResponse;
import com.amateo.java.examples.architectures.hexagonal.restapi.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerByStatus(@PathVariable final String customerId) {

        final Customer customer = Customer.builder()
                .name("gola")
                .surnames("adios")
                .id(customerId)
                .dob(LocalDate.now())
                .build();

        return ResponseEntity.ok(
                CustomerMapper.INSTANCE.customerResponseFrom(customer));
    }

}
