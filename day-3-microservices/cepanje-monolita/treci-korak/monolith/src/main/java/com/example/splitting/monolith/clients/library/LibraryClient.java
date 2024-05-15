package com.example.splitting.monolith.clients.library;

import com.example.splitting.monolith.clients.dtos.LibraryBookDto;
import com.example.splitting.monolith.clients.dtos.LibraryBorrowDto;
import com.example.splitting.monolith.clients.dtos.LibrarySaveBookDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "http://localhost:8081/v1", name = "library-service")
public interface LibraryClient {

    @GetMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LibraryBookDto> listBooks(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "page-size", defaultValue = "10") Integer pageSize
    );

    @GetMapping(path = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    LibraryBookDto getBook(@PathVariable(name = "id") Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    LibraryBookDto saveNewBook(@RequestBody @Valid LibrarySaveBookDto book);

    @PutMapping(
            path = "/books/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    LibraryBookDto updateBook(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid LibrarySaveBookDto book
    );

    @DeleteMapping(path = "/books/{id}")
    void deleteBook(@PathVariable(name = "id") Long id);

    @GetMapping(path = "/borrows", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LibraryBorrowDto> listBorrows(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "page-size", defaultValue = "10") Integer pageSize
    );

    @GetMapping(path = "/users/{userId}/borrows", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LibraryBorrowDto> listUserBorrows(
            @PathVariable(name = "userId") Long userId,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "page-size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "only-not-returned", defaultValue = "false") Boolean onlyNotReturned
    );

    @PostMapping(path = "/books/{bookId}/borrow-by/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    LibraryBorrowDto borrowBook(
            @PathVariable(name = "bookId") Long bookId,
            @PathVariable(name = "userId") Long userId
    );

    @DeleteMapping(path = "/borrow/{id}")
    void returnBook(@PathVariable(name = "id") Long id);

    @PostMapping(path = "/book/{id}/force-return")
    void forceReturnBook(@PathVariable(name = "id") Long id);

}
