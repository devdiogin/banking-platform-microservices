package com.bankingplatform.ms_user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestControllerAdvice
public class GlobalexceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseError> handleUserNotFound(UserNotFoundException e) {
        var response = new ResponseError(
                LocalDateTime.now(ZoneId.of("UTF")),
                HttpStatus.NOT_FOUND,
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handleValidationExceptions(MethodArgumentNotValidException e) {
        var response = new ResponseError(
                LocalDateTime.now(ZoneId.of("UTF")),
                HttpStatus.BAD_REQUEST,
                e.getBindingResult().getFieldErrors().stream()
                        .map(error -> error.getDefaultMessage())
                        .toList()
                        .toString()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(DuplicateCpfException.class)
    public ResponseEntity<ResponseError> handleDuplicateCpf(DuplicateCpfException e) {
        var response = new ResponseError(
                LocalDateTime.now(ZoneId.of("UTF")),
                HttpStatus.CONFLICT,
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ResponseError> handleDuplicateEmail(DuplicateEmailException e) {
        var response = new ResponseError(
                LocalDateTime.now(ZoneId.of("UTF")),
                HttpStatus.CONFLICT,
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
