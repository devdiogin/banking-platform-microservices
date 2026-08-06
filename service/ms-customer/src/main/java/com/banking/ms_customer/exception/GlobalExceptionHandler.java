package com.banking.ms_customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ResponseError> handleCustomerNotFound(CustomerNotFoundException e) {
        var response = new ResponseError(
                LocalDateTime.now(Clock.systemDefaultZone()),
                HttpStatus.NOT_FOUND,
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(CustomerConflictException.class)
    public ResponseEntity<ResponseError> handleCustomerConflict(CustomerConflictException e) {
        var response = new ResponseError(
                LocalDateTime.now(Clock.systemDefaultZone()),
                HttpStatus.CONFLICT,
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handleValidation(
            MethodArgumentNotValidException e
    ) {
        String message = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        var response = new ResponseError(
                LocalDateTime.now(Clock.systemDefaultZone()),
                HttpStatus.BAD_REQUEST,
                message
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
