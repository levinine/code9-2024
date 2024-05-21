package com.levinine.concert.monolith.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "concert")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "artist", nullable = false, length = 100)
    private String artist;

    @Column(name = "location", nullable = false, length = 100)
    private String location;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "max_ticket_number", nullable = false)
    private Integer maxTicketNumber;
}
