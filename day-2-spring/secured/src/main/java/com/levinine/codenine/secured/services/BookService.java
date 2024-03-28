package com.levinine.codenine.secured.services;

import java.util.List;
import java.util.Optional;

import com.levinine.codenine.secured.entities.Book;
import com.levinine.codenine.secured.exceptions.NotFoundException;

public interface BookService {
    List<Book> getAll();
    Optional<Book> getById(Long id);
    Book saveNew(Book book);
    void delete(Long id) throws NotFoundException;
}
