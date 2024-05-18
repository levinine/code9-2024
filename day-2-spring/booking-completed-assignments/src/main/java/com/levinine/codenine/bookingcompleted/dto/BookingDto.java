package com.levinine.codenine.bookingcompleted.dto;

import com.levinine.codenine.bookingcompleted.model.BookingStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDto {

    private Integer id;

    @NotNull
    private Integer roomId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private String guestName;

    private String guestContactInfo;

    @Min(1)
    @Max(4)
    private Integer numberOfGuests;

    private BookingStatus status;

}
