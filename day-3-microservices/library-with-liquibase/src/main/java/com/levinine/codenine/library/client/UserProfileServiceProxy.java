package com.levinine.codenine.library.client;

import com.levinine.codenine.library.client.config.UserProfileServiceConfiguration;
import com.levinine.codenine.library.dtos.UserProfileDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-profile-service", configuration = UserProfileServiceConfiguration.class)
public interface UserProfileServiceProxy {

  @GetMapping("/user-profiles")
  UserProfileDto findByLibraryCardId(@RequestParam String libraryCardId);

}
