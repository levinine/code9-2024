package com.levinine.codenine.booking.repository;

import com.levinine.codenine.booking.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

}
