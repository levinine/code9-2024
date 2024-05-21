package com.levinine.concert.monolith.repository;

import com.levinine.concert.monolith.model.Customer;
import com.levinine.concert.monolith.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByTicket(Ticket ticket);
}
