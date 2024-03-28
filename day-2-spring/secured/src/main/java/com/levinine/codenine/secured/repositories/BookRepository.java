package com.levinine.codenine.secured.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levinine.codenine.secured.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
