package com.levinine.codenine.bookingcompleted.converter;

import com.levinine.codenine.bookingcompleted.dto.BookingDto;
import com.levinine.codenine.bookingcompleted.model.Booking;
import com.levinine.codenine.bookingcompleted.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingConverter {

    public BookingDto toDto(Booking booking) {
        return BookingDto.builder()
                .id(booking.getId())
                .roomId(booking.getRoom().getId())
                .checkInDate(booking.getCheckInDate())
                .checkOutDate(booking.getCheckOutDate())
                .guestName(booking.getGuestName())
                .guestContactInfo(booking.getGuestContactInfo())
                .numberOfGuests(booking.getNumberOfGuests())
                .status(booking.getStatus())
                .build();
    }

    public Booking toEntity(BookingDto bookingDto, Room room) {
        return Booking.builder()
                .room(room)
                .checkInDate(bookingDto.getCheckInDate())
                .checkOutDate(bookingDto.getCheckOutDate())
                .guestName(bookingDto.getGuestName())
                .guestContactInfo(bookingDto.getGuestContactInfo())
                .numberOfGuests(bookingDto.getNumberOfGuests())
                .build();
    }

    public List<BookingDto> toDtoList(List<Booking> bookings) {
        return bookings.stream()
                .map(this::toDto)
                .toList();
    }

    public List<Booking> toEntityList(List<BookingDto> bookings, Room room) {
        return bookings.stream()
                .map(booking -> toEntity(booking, room))
                .toList();
    }

}
