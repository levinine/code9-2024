package com.levinine.customerservice.repository;

import com.levinine.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByTicketId(Integer ticketId);
}
