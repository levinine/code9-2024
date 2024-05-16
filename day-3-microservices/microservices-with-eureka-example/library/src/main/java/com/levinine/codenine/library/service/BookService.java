package com.levinine.codenine.library.service;

import com.levinine.codenine.library.dto.GetAllBooksDto;
import com.levinine.codenine.library.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll(GetAllBooksDto input);
    Optional<Book> getById(Long id);
}
