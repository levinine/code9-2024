package com.levinine.concert.monolith.controller;


import com.levinine.concert.monolith.dto.CustomerDto;
import com.levinine.concert.monolith.service.CustomerService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/customer")
@AllArgsConstructor
public class CustomerController {

  private CustomerService customerService;

  @GetMapping(path = "/{concertId}", produces = MediaType.APPLICATION_JSON_VALUE)
  List<CustomerDto> listTicketOwnersForAConcert(@PathVariable(name = "concertId") Integer concertId)
  {
    return customerService.listTicketOwnersForAConcert(concertId);
  }

}
