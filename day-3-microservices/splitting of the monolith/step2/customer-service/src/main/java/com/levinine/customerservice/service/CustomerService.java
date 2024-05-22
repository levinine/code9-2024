package com.levinine.customerservice.service;

import com.levinine.customerservice.dto.CustomerDto;
import com.levinine.customerservice.model.Customer;
import java.util.List;

public interface CustomerService {

  CustomerDto getCustomerForTicketId(Integer ticketId);

}
