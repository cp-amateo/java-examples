package com.amateo.java.examples.architectures.hexagonal.domain.exception;

import lombok.Getter;

@Getter
public class CustomerException extends RuntimeException {

    private final ErrorCode errorCode;

    public CustomerException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
