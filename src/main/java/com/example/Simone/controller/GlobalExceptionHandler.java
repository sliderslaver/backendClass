package com.example.Simone.controller;

import com.example.Simone.exception.ToysNotFoundException;
import com.example.Simone.exception.UserGenericErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserGenericErrorException.class)
    public ResponseEntity<String> handleUserException(UserGenericErrorException exception) {
        return ResponseEntity.status(500).body(exception.getMessage());
    }

    @ExceptionHandler(ToysNotFoundException.class)
    public ResponseEntity<String> handleUserException(ToysNotFoundException exception) {
        return ResponseEntity.status(404).body(exception.getMessage());
    }
}
