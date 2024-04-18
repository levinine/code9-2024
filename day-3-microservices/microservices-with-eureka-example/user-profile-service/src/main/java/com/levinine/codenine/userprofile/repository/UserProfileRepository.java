package com.levinine.codenine.userprofile.repository;

import com.levinine.codenine.userprofile.entity.UserProfile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

  Optional<UserProfile> findByLibraryCardId(String libraryCardId);

}
