package com.levinine.concert.monolith.controller;


import com.levinine.concert.monolith.dto.ConcertDto;
import com.levinine.concert.monolith.service.ConcertService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/concert")
@AllArgsConstructor
public class ConcertController {

  private ConcertService concertService;

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  List<ConcertDto> listConcerts()
  {
    return concertService.listConcerts();
  }

  @GetMapping(value = "/available", produces = MediaType.APPLICATION_JSON_VALUE)
  List<ConcertDto> listConcertsWithAvailableTickets()
  {
    return concertService.listConcertsWithAvailableTickets();
  }

}
