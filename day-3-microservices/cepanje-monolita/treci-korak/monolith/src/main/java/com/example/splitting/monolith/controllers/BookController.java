package com.example.splitting.monolith.controllers;

import com.example.splitting.monolith.dtos.BookDto;
import com.example.splitting.monolith.dtos.SaveBookDto;
import com.example.splitting.monolith.exceptions.NotFoundException;
import com.example.splitting.monolith.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<BookDto> listBooks(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "page-size", defaultValue = "10") Integer pageSize
    ) {
        return bookService.list(
                page == null ? 0 : page,
                pageSize == null ? 10 : pageSize
                );
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    BookDto getBook(@PathVariable(name = "id") Long id)  {
        return bookService.getBook(id);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    BookDto saveNew(@RequestBody @Valid SaveBookDto book) {
        return bookService.saveNew(book);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(
            path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    BookDto update(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid SaveBookDto book
    ) {
        return bookService.update(id, book);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable(name = "id") Long id) {
        bookService.delete(id);
    }
}
