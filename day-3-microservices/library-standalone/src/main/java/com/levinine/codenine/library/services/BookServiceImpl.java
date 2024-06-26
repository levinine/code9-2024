package com.levinine.codenine.library.services;

import com.levinine.codenine.library.dtos.GetAllBooksDto;
import com.levinine.codenine.library.entities.Book;
import com.levinine.codenine.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll(GetAllBooksDto input) {
        return bookRepository.findAll(PageRequest.of(input.page(), input.limit()))
                .stream()
                .toList();
    }

    @Override
    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }
}
