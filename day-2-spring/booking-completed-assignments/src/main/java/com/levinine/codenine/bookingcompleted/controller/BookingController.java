package com.levinine.codenine.bookingcompleted.controller;

import com.levinine.codenine.bookingcompleted.dto.BookingDto;
import com.levinine.codenine.bookingcompleted.service.BookingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
@Slf4j
@Validated
public class BookingController {

    private BookingService bookingService;

    @PostMapping
    public BookingDto createBooking(@Valid @RequestBody BookingDto bookingDto) {
        log.info("Creating new Booking for guest: {}", bookingDto.getGuestName());
        return bookingService.saveBooking(bookingDto);
    }

    @DeleteMapping(value = "/{id}")
    public BookingDto cancelBooking(@PathVariable("id") Integer bookingId) {
        return bookingService.cancelBooking(bookingId);
    }
}
