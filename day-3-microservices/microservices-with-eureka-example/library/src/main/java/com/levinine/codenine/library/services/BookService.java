package com.levinine.codenine.library.services;

import com.levinine.codenine.library.dtos.GetAllBooksDto;
import com.levinine.codenine.library.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll(GetAllBooksDto input);
    Optional<Book> getById(Long id);
}
