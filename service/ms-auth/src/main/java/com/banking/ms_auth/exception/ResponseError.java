package com.banking.ms_auth.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ResponseError(LocalDateTime time, HttpStatus httpStatus, Object message) {
}
