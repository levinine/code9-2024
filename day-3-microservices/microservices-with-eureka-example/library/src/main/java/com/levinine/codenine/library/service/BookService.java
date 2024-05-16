package com.levinine.codenine.library.service;

import com.levinine.codenine.library.dto.BookDto;
import com.levinine.codenine.library.dto.GetAllBooksDto;
import com.levinine.codenine.library.entity.Book;
import com.levinine.codenine.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<BookDto> getAll(final GetAllBooksDto input) {
        return bookRepository.findAll(PageRequest.of(input.page(), input.limit()))
                .stream()
                .map(BookDto::fromBook)
                .toList();
    }

    public Optional<Book> getById(final Long id) {
        return bookRepository.findById(id);
    }

}
