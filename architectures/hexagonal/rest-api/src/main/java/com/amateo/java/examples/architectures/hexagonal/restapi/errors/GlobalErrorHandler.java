package com.amateo.java.examples.architectures.hexagonal.restapi.errors;

import com.amateo.java.examples.architectures.hexagonal.domain.exception.CustomerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<ErrorResponse> handleCustomerException(final CustomerException customerException) {

        final ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(customerException.getErrorCode())
                .message(customerException.getMessage())
                .build();

        logger.error(errorResponse.toString(), customerException);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
