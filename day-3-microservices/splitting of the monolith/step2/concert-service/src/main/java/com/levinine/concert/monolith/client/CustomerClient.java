package com.levinine.concert.monolith.client;

import com.levinine.concert.monolith.client.TicketDto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(url= "localhost:8082",name = "customer-service")
public interface CustomerClient {

  @GetMapping(path = "/ticket/{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE)
  CustomerDto getCustomerForTicketId(@PathVariable(name = "ticketId") Integer ticketId);

}
