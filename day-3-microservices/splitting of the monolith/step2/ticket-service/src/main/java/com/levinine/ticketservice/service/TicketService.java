package com.levinine.ticketservice.service;

import com.levinine.ticketservice.dto.TicketDto;
import java.util.List;

public interface TicketService {

  List<TicketDto> getTicketsForConcert(Integer concertId);

}
