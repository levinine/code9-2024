package com.levinine.customerservice.controller;

import com.levinine.customerservice.dto.CustomerDto;
import com.levinine.customerservice.service.CustomerService;
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

  @GetMapping(path = "/ticket/{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE)
  CustomerDto getCustomerForTicketId(@PathVariable(name = "ticketId") Integer ticketId)
  {
    return customerService.getCustomerForTicketId(ticketId);
  }

}
