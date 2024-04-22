package com.levinine.codenine.library.client;

import com.levinine.codenine.library.dtos.UserProfileDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserProfileServiceClient {

  private final UserProfileServiceProxy userProfileServiceProxy;

  public UserProfileDto findUserProfileByLibraryCardId(String libraryCardId) {
    return userProfileServiceProxy.findByLibraryCardId(libraryCardId);
  }

}
