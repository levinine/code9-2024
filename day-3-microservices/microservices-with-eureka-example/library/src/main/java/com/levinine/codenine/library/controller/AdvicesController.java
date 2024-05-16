package com.levinine.codenine.library.controller;

import com.levinine.codenine.library.dto.ErrorDto;
import com.levinine.codenine.library.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AdvicesController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFound(
            NotFoundException ex, WebRequest req
    ) {
        return new ResponseEntity<>(
                new ErrorDto(ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
