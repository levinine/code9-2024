package com.levinine.concert.monolith.mapper;

import com.levinine.concert.monolith.dto.ConcertDto;
import com.levinine.concert.monolith.model.Concert;
import org.springframework.stereotype.Component;

@Component
public class ConcertMapper {

  public ConcertDto toDto(Concert concert) {
    return ConcertDto.builder()
        .artist(concert.getArtist())
        .location(concert.getLocation())
        .date(concert.getDate())
        .build();
  }

}
