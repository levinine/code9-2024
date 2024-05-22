package com.levinine.concert.monolith.service;

import com.levinine.concert.monolith.dto.ConcertDto;
import java.util.List;

public interface ConcertService {

  List<ConcertDto> listConcerts();
  List<ConcertDto> listConcertsWithAvailableTickets();

}
