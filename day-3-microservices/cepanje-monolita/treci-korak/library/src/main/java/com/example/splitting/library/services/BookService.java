package com.example.splitting.library.services;

import com.example.splitting.library.dtos.SaveBookDto;
import com.example.splitting.library.entities.Book;
import com.example.splitting.library.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> list(int page, int pageSize);
    Optional<Book> getBook(Long id);
    Book saveNew(SaveBookDto book);
    Book update(Long id, SaveBookDto book) throws NotFoundException;
    void delete(Long id) throws NotFoundException;
}
