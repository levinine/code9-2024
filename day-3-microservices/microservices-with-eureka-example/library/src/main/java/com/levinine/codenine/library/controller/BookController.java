package com.levinine.codenine.library.controller;

import com.levinine.codenine.library.dto.BookDto;
import com.levinine.codenine.library.dto.GetAllBooksDto;
import com.levinine.codenine.library.exception.NotFoundException;
import com.levinine.codenine.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<BookDto> getBooksWithPaging(
            @RequestParam(name = "page", required = false) final Integer page,
            @RequestParam(name = "limit", required = false) final Integer limit) {
        final var pageParam = page == null ? 0 : page;
        final var limitParam = limit == null ? 10 : limit;

        return bookService.getAll(new GetAllBooksDto(limitParam, pageParam));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    BookDto getOneBook(@PathVariable("id") final Long id) throws NotFoundException {
        return BookDto.fromBook(bookService.getById(id).orElseThrow(() -> new NotFoundException("book not found")));
    }
}
