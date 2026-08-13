package com.banking.ms_auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Clock;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotCreatedException.class)
    public ResponseEntity<ResponseError> handleCustomerNotFound(UserNotCreatedException e) {
        var response = new ResponseError(
                LocalDateTime.now(Clock.systemDefaultZone()),
                HttpStatus.BAD_REQUEST,
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseError> handleCustomerNotFound(UserNotFoundException e) {
        var response = new ResponseError(
                LocalDateTime.now(Clock.systemDefaultZone()),
                HttpStatus.NOT_FOUND,
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
