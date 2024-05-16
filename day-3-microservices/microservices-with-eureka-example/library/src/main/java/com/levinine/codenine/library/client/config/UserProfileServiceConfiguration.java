package com.levinine.codenine.library.client.config;

import com.levinine.codenine.library.exception.NotFoundException;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class UserProfileServiceConfiguration {

  @Bean
  public ErrorDecoder userProfileServiceErrorDecoder() {
    return (methodKey, response) -> {
      if (response.status() == 404) {
        return new NotFoundException("Library member not found in user-profile-service");
      }
      return new RuntimeException("Error in communication with user-profile-service");
    };
  }

}
