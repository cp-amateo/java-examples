package com.amateo.java.examples.architectures.hexagonal.restapi.controller;

import com.amateo.java.examples.architectures.hexagonal.domain.model.Customer;
import com.amateo.java.examples.architectures.hexagonal.domain.service.CustomerService;
import com.amateo.java.examples.architectures.hexagonal.restapi.dto.CustomerDTO;
import com.amateo.java.examples.architectures.hexagonal.restapi.dto.CustomerIdDTO;
import com.amateo.java.examples.architectures.hexagonal.restapi.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(
            @PathVariable final String customerId) {

        final Customer customer = customerService.findCustomerById(customerId);

        return ResponseEntity.ok(
                CustomerMapper.INSTANCE.customerDTOFrom(customer));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerIdDTO> createCustomer(
            @Valid @RequestBody final CustomerDTO customerDTO) {

        final Customer customer = customerService.createCustomer(CustomerMapper.INSTANCE.customerFrom(customerDTO));

        return new ResponseEntity<>(
                CustomerMapper.INSTANCE.customerIdDTOFrom(customer),
                HttpStatus.CREATED);
    }
}
