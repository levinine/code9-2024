package com.levinine.concert.monolith.repository;

import com.levinine.concert.monolith.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {

}
