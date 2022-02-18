package com.amateo.java.examples.architectures.hexagonal.restapi.errors;

import com.amateo.java.examples.architectures.hexagonal.domain.exception.CustomerException;
import com.amateo.java.examples.architectures.hexagonal.domain.exception.ErrorCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class GlobalErrorHandlerShould {

    @InjectMocks
    private GlobalErrorHandler globalErrorHandler;

    @Test
    void handle_entity_not_found_exception_entity_not_found_exception() {
        final String message = "CustomerException";

        final var responseEntity = globalErrorHandler.handleCustomerException(
                new CustomerException(ErrorCode.ENTITY_NOT_FOUND, message));

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(responseEntity.getBody().getErrorCode())
                .isEqualTo(ErrorCode.ENTITY_NOT_FOUND);
        assertThat(responseEntity.getBody().getMessage())
                .isEqualTo(message);
    }

}