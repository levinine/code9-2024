package com.levinine.codenine.bookingcompleted.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
