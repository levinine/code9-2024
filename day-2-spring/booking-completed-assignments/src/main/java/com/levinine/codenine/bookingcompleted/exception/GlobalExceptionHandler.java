package com.levinine.codenine.bookingcompleted.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

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

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDetails> handleValidationException(MethodArgumentNotValidException ex) {
    String errorTemplate = "Invalid field: %s, reason: %s, rejected value: %s;";
    List<String> causes = ex.getBindingResult().getFieldErrors().stream().map(e -> String
            .format(errorTemplate, e.getField(), e.getDefaultMessage(), e.getRejectedValue())).toList();

    ErrorDetails errorDetails = ErrorDetails.builder()
            .status(HttpStatus.NOT_ACCEPTABLE)
            .causes(causes)
            .build();

    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }

}
