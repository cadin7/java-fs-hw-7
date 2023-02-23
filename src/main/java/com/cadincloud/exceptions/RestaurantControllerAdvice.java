package com.cadincloud.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class RestaurantControllerAdvice {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    ApiError handleResourceNotFoundException(ResourceNotFoundException rnfe) {
        return new ApiError(1001, rnfe.getMessage());
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(ValidationException.class)
    ApiError handleValidationException(ValidationException ve) {
        return new ApiError(1002, ve.getMessage());
    }
}

record ApiError(int code, String message) {
}
