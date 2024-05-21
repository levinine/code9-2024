package com.levinine.concert.monolith.service;

import com.levinine.concert.monolith.repository.TicketRepository;
import com.levinine.concert.monolith.model.Concert;
import com.levinine.concert.monolith.model.Ticket;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

  private TicketRepository ticketRepository;
  @Override
  public List<Ticket> getTicketsForConcert(Concert concert) {
    return ticketRepository.getTicketsByConcert(concert);
  }
}
