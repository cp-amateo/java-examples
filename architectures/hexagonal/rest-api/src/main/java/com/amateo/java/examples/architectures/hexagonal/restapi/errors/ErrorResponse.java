package com.amateo.java.examples.architectures.hexagonal.restapi.errors;

public record ErrorResponse(String errorCode, String message) {

    @Override
    public String toString() {
        return "errorCode: '" + errorCode + "', " +
               "message: '" + message + '\'';
    }

}
