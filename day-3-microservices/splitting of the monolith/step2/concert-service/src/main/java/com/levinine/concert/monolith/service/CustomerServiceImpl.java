package com.levinine.concert.monolith.service;

import com.levinine.concert.monolith.client.CustomerClient;
import com.levinine.concert.monolith.client.TicketClient;
import com.levinine.concert.monolith.client.TicketDto;
import com.levinine.concert.monolith.client.TicketDto.CustomerDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private CustomerClient customerClient;
  private TicketClient ticketClient;

  @Override
  public List<CustomerDto> listTicketOwnersForAConcert(Integer concertId) {
    List<TicketDto> tickets = ticketClient.getTicketsForConcert(concertId);
    List<CustomerDto> customers = tickets.stream().map(it -> customerClient.getCustomerForTicketId(it.getId()))
        .collect(Collectors.toList());

    return customers;
  }

}
