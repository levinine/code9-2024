package com.levinine.codenine.gateway.controllers;

import com.levinine.codenine.gateway.services.BookService;
import com.levinine.codenine.gateway.services.books.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDto> list(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "pageSize", required = false) Integer pageSize
    ) {
        return bookService.getAll(page, pageSize);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> getById(@PathVariable(name = "id") Long id) {
        var bookOpt = bookService.getOneById(id);
        return bookOpt.isPresent() ?
            ResponseEntity.of(bookOpt)
                : ResponseEntity.notFound().build();
    }
}
