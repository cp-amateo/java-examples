package com.amateo.java.examples.aws.cognito.restapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
@Slf4j
@RequiredArgsConstructor
public class AuthenticationController {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(
            @RequestBody final String string) {

    }

}
