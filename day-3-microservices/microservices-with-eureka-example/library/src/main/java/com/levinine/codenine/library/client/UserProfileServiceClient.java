package com.levinine.codenine.library.client;

import com.levinine.codenine.library.dto.UserProfileDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-profile-service")
public interface UserProfileServiceClient {

    @GetMapping
    UserProfileDto findByLibraryCardId(@RequestParam final String libraryCardId);

}
