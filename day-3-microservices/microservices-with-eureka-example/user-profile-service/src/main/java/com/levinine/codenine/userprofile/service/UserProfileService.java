package com.levinine.codenine.userprofile.service;

import com.levinine.codenine.userprofile.dto.UserProfileDto;
import com.levinine.codenine.userprofile.repository.UserProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserProfileService {

  private final UserProfileRepository userProfileRepository;

  public UserProfileDto findUserProfileById(final Long id) {
    final var userProfile = userProfileRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(
            String.format("User with id %s not found", id)));
    return UserProfileDto.fromUserProfile(userProfile);
  }

  public UserProfileDto findByLibraryCardId(final String libraryCardId) {
    final var userProfile = userProfileRepository.findByLibraryCardId(libraryCardId)
        .orElseThrow(() -> new EntityNotFoundException(
            String.format("User with library card %s not found", libraryCardId)));
    return UserProfileDto.fromUserProfile(userProfile);
  }

}
