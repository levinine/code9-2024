package com.levinine.codenine.userprofile.dto;

import com.levinine.codenine.userprofile.entity.UserProfile;

public record UserProfileDto(Long id, String firstName, String lastName, String address,
                             String libraryCardId) {

  public static UserProfileDto fromUserProfile(final UserProfile userProfile) {
    return new UserProfileDto(userProfile.getId(), userProfile.getFirstName(),
        userProfile.getLastName(), userProfile.getAddress(), userProfile.getLibraryCardId());
  }

}
