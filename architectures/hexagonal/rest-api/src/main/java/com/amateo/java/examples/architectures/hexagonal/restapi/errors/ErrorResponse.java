package com.amateo.java.examples.architectures.hexagonal.restapi.errors;

import com.amateo.java.examples.architectures.hexagonal.domain.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    private final ErrorCode errorCode;
    private final String message;

    @Override
    public String toString() {
        return """
                Error (
                    Error code: %s,
                    Message:    %s
                )""".formatted(errorCode, message);
    }

}
