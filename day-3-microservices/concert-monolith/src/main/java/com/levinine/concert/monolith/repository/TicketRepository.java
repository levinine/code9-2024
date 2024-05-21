package com.levinine.concert.monolith.repository;

import com.levinine.concert.monolith.model.Concert;
import com.levinine.concert.monolith.model.Ticket;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

   List<Ticket> getTicketsByConcert(Concert concert);

}
