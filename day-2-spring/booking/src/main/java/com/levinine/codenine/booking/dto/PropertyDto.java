package com.levinine.codenine.booking.dto;

import java.util.List;
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

  private String name;

  private String address;

  private String contactPhone;

  private List<RoomDto> rooms;

}
