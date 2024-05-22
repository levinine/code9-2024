package com.levinine.concert.monolith.service;

import com.levinine.concert.monolith.client.TicketClient;
import com.levinine.concert.monolith.client.TicketDto;
import com.levinine.concert.monolith.dto.CustomerDto;
import com.levinine.concert.monolith.mapper.CustomerMapper;
import com.levinine.concert.monolith.repository.ConcertRepository;
import com.levinine.concert.monolith.repository.CustomerRepository;
import com.levinine.concert.monolith.model.Concert;
import com.levinine.concert.monolith.model.Customer;
import com.levinine.concert.monolith.model.Ticket;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private CustomerRepository customerRepository;
  private CustomerMapper customerMapper;
  private TicketClient ticketClient;

  @Override
  public List<CustomerDto> listTicketOwnersForAConcert(Integer concertId) {
    List<TicketDto> tickets = ticketClient.getTicketsForConcert(concertId);
    List<Customer> customers = tickets.stream().map(it -> getCustomerForATicket(it.getId())).toList();
    List<CustomerDto> customersDto = customers.stream().map(it -> customerMapper.toDto(it)).toList();

    return customersDto;
  }

  private Customer getCustomerForATicket(Integer ticketId) {
    return customerRepository.findByTicketId(ticketId);
  }
}
