package com.example.splitting.monolith.services;

import com.example.splitting.monolith.dtos.SaveBookDto;
import com.example.splitting.monolith.entities.Book;
import com.example.splitting.monolith.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> list(int page, int pageSize);
    Optional<Book> getBook(Long id);
    Book saveNew(SaveBookDto book);
    Book update(Long id, SaveBookDto book) throws NotFoundException;
    void delete(Long id) throws NotFoundException;
}
