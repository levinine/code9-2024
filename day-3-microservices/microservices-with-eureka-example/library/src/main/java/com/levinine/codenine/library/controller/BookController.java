package com.levinine.codenine.library.controller;

import com.levinine.codenine.library.dto.BookDto;
import com.levinine.codenine.library.dto.GetAllBooksDto;
import com.levinine.codenine.library.exceptions.NotFoundException;
import com.levinine.codenine.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    List<BookDto> getBooksWithPaging(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "limit", required = false) Integer limit
    ) {
        var pageParam = page == null ? 0 : page;
        var limitParam = limit == null ? 10 : limit;
        return bookService.getAll(new GetAllBooksDto(limitParam, pageParam))
                .stream()
                .map(BookDto::fromBook)
                .toList();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    BookDto getOneBook(@PathVariable("id") Long id) throws NotFoundException {
        return BookDto.fromBook(
                bookService.getById(id)
                    .orElseThrow(() -> new NotFoundException("book not found"))
                );
    }
}
