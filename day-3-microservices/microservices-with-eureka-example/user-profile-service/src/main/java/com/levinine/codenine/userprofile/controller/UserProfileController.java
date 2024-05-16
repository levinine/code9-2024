package com.levinine.codenine.userprofile.controller;

import com.levinine.codenine.userprofile.dto.UserProfileDto;
import com.levinine.codenine.userprofile.service.UserProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-profiles")
@AllArgsConstructor
public class UserProfileController {

  private final UserProfileService userProfileService;

  @GetMapping("/{id}")
  public UserProfileDto findById(@PathVariable final Long id) {
    return userProfileService.findUserProfileById(id);
  }

  @GetMapping
  public UserProfileDto findByLibraryCardId(@RequestParam final String libraryCardId) {
    return userProfileService.findByLibraryCardId(libraryCardId);
  }

}
