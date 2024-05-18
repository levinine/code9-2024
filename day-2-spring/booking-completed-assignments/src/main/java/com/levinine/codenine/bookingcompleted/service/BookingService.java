package com.levinine.codenine.bookingcompleted.service;

import com.levinine.codenine.bookingcompleted.converter.BookingConverter;
import com.levinine.codenine.bookingcompleted.dto.BookingDto;
import com.levinine.codenine.bookingcompleted.model.Booking;
import com.levinine.codenine.bookingcompleted.model.BookingStatus;
import com.levinine.codenine.bookingcompleted.model.Room;
import com.levinine.codenine.bookingcompleted.model.RoomStatus;
import com.levinine.codenine.bookingcompleted.repository.BookingRepository;
import com.levinine.codenine.bookingcompleted.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final BookingConverter bookingConverter;

    @Transactional
    public BookingDto saveBooking(BookingDto bookingDto) {
        Room room = roomRepository.findByIdAndStatus(bookingDto.getRoomId(), RoomStatus.AVAILABLE).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("Available room with id: %s not found", bookingDto.getRoomId())));
        final Booking booking = bookingConverter.toEntity(bookingDto, room);
        booking.setStatus(BookingStatus.CONFIRMED);
        Booking savedBooking = bookingRepository.save(booking);
        room.setStatus(RoomStatus.BOOKED);
        roomRepository.save(room);
        log.info("Room with id: {} booked", savedBooking.getRoom().getId());
        return bookingConverter.toDto(savedBooking);
    }

    @Transactional
    public BookingDto cancelBooking(Integer bookingId) {
        Booking booking = bookingRepository.findByIdAndStatus(bookingId, BookingStatus.CONFIRMED).orElseThrow(
                () -> new EntityNotFoundException(String.format("Confirmed booking with id: %s not found", bookingId)));
        Room room = roomRepository.findByIdAndStatus(booking.getRoom().getId(), RoomStatus.BOOKED).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("Booked room with id: %s not found", booking.getRoom().getId())));
        booking.setStatus(BookingStatus.CANCELED);
        bookingRepository.save(booking);
        room.setStatus(RoomStatus.AVAILABLE);
        roomRepository.save(room);
        log.info("Booking with id: {} canceled", booking.getId());
        return bookingConverter.toDto(booking);
    }

}
