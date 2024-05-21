package com.levinine.concert.monolith.service;

import com.levinine.concert.monolith.dto.CustomerDto;
import com.levinine.concert.monolith.mapper.CustomerMapper;
import com.levinine.concert.monolith.repository.ConcertRepository;
import com.levinine.concert.monolith.repository.CustomerRepository;
import com.levinine.concert.monolith.repository.TicketRepository;
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
  private TicketRepository ticketRepository;
  private CustomerMapper customerMapper;
  private ConcertRepository concertRepository;

  @Override
  public List<CustomerDto> listTicketOwnersForAConcert(Long concertId) {
    Optional<Concert> concert = concertRepository.findById(concertId);
    List<Ticket> tickets = ticketRepository.getTicketsByConcert(concert.orElseThrow(()-> new IllegalStateException()));
    List<Customer> customers = tickets.stream().map(it -> getCustomerForATicket(it)).toList();
    List<CustomerDto> customersDto = customers.stream().map(it -> customerMapper.toDto(it)).toList();

    return customersDto;
  }

  private Customer getCustomerForATicket(Ticket ticket) {
    return customerRepository.findByTicket(ticket);
  }
}
