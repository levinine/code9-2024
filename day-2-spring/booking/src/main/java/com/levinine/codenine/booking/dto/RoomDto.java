package com.levinine.codenine.booking.dto;

import com.levinine.codenine.booking.model.RoomStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto {

  private Integer id;

  private Integer propertyId;

  @NotNull
  private String roomNumber;

  @NotNull
  @Min(value = 10, message = "Value must be greater than 1")
  private Double price;

  private RoomStatus status;

}
