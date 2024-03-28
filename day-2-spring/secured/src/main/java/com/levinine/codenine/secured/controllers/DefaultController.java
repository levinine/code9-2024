package com.levinine.codenine.secured.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.levinine.codenine.secured.dtos.ErrorDto;
import com.levinine.codenine.secured.exceptions.NotFoundException;
import com.levinine.codenine.secured.exceptions.UnauthorizedException;

@ControllerAdvice
public class DefaultController {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFound(
            NotFoundException ex, WebRequest req
    ) {
        return new ResponseEntity<ErrorDto>(
            new ErrorDto(ex.getMessage()),
            HttpStatus.NOT_FOUND
        );
    }
    
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorDto> handleUnauthorized(
            UnauthorizedException ex, WebRequest req
    ) {
        return new ResponseEntity<ErrorDto>(
            new ErrorDto(ex.getMessage()),
            HttpStatus.UNAUTHORIZED
        );
    }
}
