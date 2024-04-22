package com.levinine.codenine.userprofile.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ErrorDetails {

  private HttpStatus status;

  private String message;

}