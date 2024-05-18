package com.levinine.codenine.booking.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyDto {

  private Integer id;

  @NotBlank
  private String name;

  @NotBlank
  private String address;

  private String contactPhone;

  @Valid
  private List<RoomDto> rooms;

}
