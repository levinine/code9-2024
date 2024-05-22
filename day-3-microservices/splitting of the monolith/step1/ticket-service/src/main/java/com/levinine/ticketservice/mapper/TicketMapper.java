package com.levinine.ticketservice.mapper;

import com.levinine.ticketservice.dto.TicketDto;
import com.levinine.ticketservice.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

  public TicketDto toDto(Ticket ticket) {
    return TicketDto.builder().price(ticket.getPrice()).id(ticket.getId()).concertId(ticket.getConcertId()).build();
  }
}
