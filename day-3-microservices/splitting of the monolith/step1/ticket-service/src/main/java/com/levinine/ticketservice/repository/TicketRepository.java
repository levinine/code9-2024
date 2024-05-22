package com.levinine.ticketservice.repository;

import com.levinine.ticketservice.model.Ticket;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

   List<Ticket> getTicketsByConcertId(Integer concertId);

}
