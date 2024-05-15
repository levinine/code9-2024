package com.example.splitting.library.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "borrows")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "take_time", nullable = false)
    private Date takeTime;

    @Column(name = "return_time", nullable = true)
    private Date returnTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrowed_book_id", nullable = false)
    private Book book;

    @Column(name = "borrower_id", nullable = false)
    private Long borrowerId;
}