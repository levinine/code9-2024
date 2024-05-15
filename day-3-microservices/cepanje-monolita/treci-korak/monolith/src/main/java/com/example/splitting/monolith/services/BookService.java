package com.example.splitting.monolith.services;

import com.example.splitting.monolith.dtos.BookDto;
import com.example.splitting.monolith.dtos.SaveBookDto;
import com.example.splitting.monolith.exceptions.NotFoundException;

import java.util.List;

public interface BookService {
    List<BookDto> list(int page, int pageSize);
    BookDto getBook(Long id);
    BookDto saveNew(SaveBookDto book);
    BookDto update(Long id, SaveBookDto book);
    void delete(Long id);
}
