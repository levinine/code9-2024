package com.levinine.concert.monolith.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(url= "localhost:8081",name = "ticket-service")
public interface TicketClient {

  @GetMapping(path = "/concert/{concertId}", produces = MediaType.APPLICATION_JSON_VALUE)
  List<TicketDto> getTicketsForConcert(@PathVariable Integer concertId);

}
