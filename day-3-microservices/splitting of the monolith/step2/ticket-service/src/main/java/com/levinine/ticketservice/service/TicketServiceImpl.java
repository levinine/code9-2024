package com.levinine.ticketservice.service;
import com.levinine.ticketservice.dto.TicketDto;
import com.levinine.ticketservice.mapper.TicketMapper;
import com.levinine.ticketservice.repository.TicketRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

  private TicketRepository ticketRepository;
  private TicketMapper ticketMapper;
  @Override
  public List<TicketDto> getTicketsForConcert(Integer concertId) {

    return ticketRepository.getTicketsByConcertId(concertId).stream().map(it -> ticketMapper.toDto(it))
        .collect(Collectors.toList());
  }
}
