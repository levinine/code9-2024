package com.levinine.codenine.library.repositories;

import com.levinine.codenine.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>, JpaRepository<Book, Long> {
}
