package com.levinine.codenine.bookingcompleted.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Room room;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private String guestName;

    private String guestContactInfo;

    private Integer numberOfGuests;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

}
