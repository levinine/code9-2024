package com.levinine.concert.monolith.service;

import com.levinine.concert.monolith.client.TicketDto.CustomerDto;
import java.util.List;

public interface CustomerService {

  List<CustomerDto> listTicketOwnersForAConcert(Integer concertId);

}
