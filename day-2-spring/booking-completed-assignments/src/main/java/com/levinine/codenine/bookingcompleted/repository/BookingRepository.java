package com.levinine.codenine.bookingcompleted.repository;

import com.levinine.codenine.bookingcompleted.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
