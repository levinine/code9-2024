package com.levinine.concert.monolith.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto {
  private Integer id;
  private Integer price;
  private Integer concertId;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class CustomerDto {

    private Integer id;
    private String name;
    private String email;

  }
}
