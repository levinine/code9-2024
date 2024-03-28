package com.levinine.codenine.gateway.services;

import com.levinine.codenine.gateway.services.books.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDto> getAll(Integer page, Integer pageSize);
    Optional<BookDto> getOneById(Long id);
}
