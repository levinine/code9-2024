package com.levinine.concert.monolith.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConcertDto {

  private String artist;
  private String location;
  private LocalDate date;
}
