package com.levinine.codenine.booking.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ErrorDetails> handleEntityNotFound(EntityNotFoundException ex) {

    ErrorDetails errorDetails = ErrorDetails.builder()
        .status(HttpStatus.NOT_FOUND)
        .message(ex.getMessage())
        .build();

    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }

}
