package com.levinine.ticketservice.controller;

import com.levinine.ticketservice.dto.TicketDto;
import com.levinine.ticketservice.service.TicketService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TicketController {

  private TicketService ticketService;

  @GetMapping(path = "/concert/{concertId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<TicketDto> getTicketsForConcert(@PathVariable Integer concertId){
      return ticketService.getTicketsForConcert(concertId);
  }

}
