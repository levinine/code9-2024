package com.levinine.customerservice.service;

import com.levinine.customerservice.dto.CustomerDto;
import com.levinine.customerservice.mapper.CustomerMapper;
import com.levinine.customerservice.repository.CustomerRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

  private CustomerRepository customerRepository;
  private CustomerMapper customerMapper;

  @Override
  public CustomerDto getCustomerForTicketId(Integer ticketId) {
    return customerMapper.toDto(customerRepository.findByTicketId(ticketId));
  }

}

