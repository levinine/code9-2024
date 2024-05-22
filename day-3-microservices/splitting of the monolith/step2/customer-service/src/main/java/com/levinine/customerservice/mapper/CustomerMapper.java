package com.levinine.customerservice.mapper;

import com.levinine.customerservice.dto.CustomerDto;
import com.levinine.customerservice.model.Customer;
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
