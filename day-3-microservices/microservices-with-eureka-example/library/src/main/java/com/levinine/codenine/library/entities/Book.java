package com.levinine.codenine.library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false, length = 30, columnDefinition = "VARCHAR(30)")
    private String name;

    @Column(name = "year_published", nullable = false, columnDefinition = "INTEGER")
    private Integer yearPublished;
}
