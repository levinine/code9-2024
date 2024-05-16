package com.example.splitting.monolith.controllers;

import com.example.splitting.monolith.dtos.ErrorDto;
import com.example.splitting.monolith.exceptions.NotFoundException;
import com.example.splitting.monolith.exceptions.ResourceAlreadyTakenException;
import com.example.splitting.monolith.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class DefaultController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFound(
            NotFoundException ex, WebRequest req
    ) {
        return new ResponseEntity<>(
                new ErrorDto(ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorDto> handleUnauthorized(
            UnauthorizedException ex, WebRequest req
    ) {
        return new ResponseEntity<>(
                new ErrorDto(ex.getMessage()),
                HttpStatus.UNAUTHORIZED
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
