package com.example.splitting.library.controllers;

import com.example.splitting.library.dtos.ErrorDto;
import com.example.splitting.library.exceptions.NotFoundException;
import com.example.splitting.library.exceptions.ResourceAlreadyTakenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class DefaultControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFound(
            NotFoundException ex, WebRequest req
    ) {
        return new ResponseEntity<>(
                new ErrorDto(ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ResourceAlreadyTakenException.class)
    public ResponseEntity<ErrorDto> handleResourceConflict(
            ResourceAlreadyTakenException ex, WebRequest req
    ) {
        return new ResponseEntity<>(
                new ErrorDto(ex.getMessage()),
                HttpStatus.CONFLICT
        );
    }
}