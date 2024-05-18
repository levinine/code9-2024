package com.levinine.codenine.bookingcompleted.repository;

import com.levinine.codenine.bookingcompleted.model.Booking;
import com.levinine.codenine.bookingcompleted.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Optional<Booking> findByIdAndStatus(Integer bookingId, BookingStatus status);

}
