package com.levinine.codenine.secured.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.levinine.codenine.secured.dtos.BookDto;
import com.levinine.codenine.secured.dtos.SaveBookDto;
import com.levinine.codenine.secured.entities.Book;
import com.levinine.codenine.secured.exceptions.NotFoundException;
import com.levinine.codenine.secured.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
    
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDto> getAll() {
        return bookService.getAll().stream()
            .map(BookDto::fromBook)
            .toList();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto getById(@PathVariable("id") Long id) throws NotFoundException {
        var book = bookService.getById(id)
            .orElseThrow(() -> new NotFoundException("book not found"));
        return BookDto.fromBook(book);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookDto saveNewBook(@RequestBody SaveBookDto body) {
        return BookDto.fromBook(
            bookService.saveNew(
                Book.builder()
                    .title(body.title())
                    .yearPublished(body.yearPublished())
                    .build()
            )
        );
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBook(@PathVariable("id") Long id) throws NotFoundException {
        bookService.delete(id);
    }
}
