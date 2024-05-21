package com.levinine.concert.monolith.mapper;

import com.levinine.concert.monolith.dto.CustomerDto;
import com.levinine.concert.monolith.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
  public CustomerDto toDto(Customer customer) {
    return CustomerDto.builder()
        .name(customer.getName())
        .email(customer.getEmail())
        .build();
  }
}
