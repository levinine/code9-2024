package com.levinine.concert.monolith.service;

import com.levinine.concert.monolith.model.Concert;
import com.levinine.concert.monolith.model.Ticket;
import java.util.List;

public interface TicketService {

  List<Ticket> getTicketsForConcert(final Concert concert);

}
