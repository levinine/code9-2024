package com.levinine.concert.monolith.service;

import com.levinine.concert.monolith.client.TicketClient;
import com.levinine.concert.monolith.dto.ConcertDto;
import com.levinine.concert.monolith.repository.ConcertRepository;
import com.levinine.concert.monolith.mapper.ConcertMapper;
import com.levinine.concert.monolith.model.Concert;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConcertServiceImpl implements ConcertService {

  private ConcertRepository concertRepository;
  private ConcertMapper mapper;
  private TicketClient ticketClient;

  @Override
  public List<ConcertDto> listConcerts() {
    return concertRepository.findAll().stream().map(it -> mapper.toDto(it)).toList();
  }

  @Override
  public List<ConcertDto> listConcertsWithAvailableTickets() {
    List<Concert> concerts = concertRepository.findAll();

    List<ConcertDto> concertsWithAvailableTickets = concerts.stream()
        .filter(it -> ticketClient.getTicketsForConcert(it.getId()).size() < it.getMaxTicketNumber())
        .map(it -> mapper.toDto(it)).toList();

    return concertsWithAvailableTickets;
  }
}
