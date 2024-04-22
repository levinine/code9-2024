package com.example.splitting.monolith.repositories;

import com.example.splitting.monolith.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>, JpaRepository<Book, Long> {
}
