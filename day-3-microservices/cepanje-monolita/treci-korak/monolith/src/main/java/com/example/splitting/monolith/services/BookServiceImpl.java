package com.example.splitting.monolith.services;

import com.example.splitting.monolith.clients.dtos.LibraryBookDto;
import com.example.splitting.monolith.clients.dtos.LibrarySaveBookDto;
import com.example.splitting.monolith.clients.library.LibraryClient;
import com.example.splitting.monolith.dtos.BookDto;
import com.example.splitting.monolith.dtos.SaveBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    private final LibraryClient libraryClient;

    @Autowired
    public BookServiceImpl(LibraryClient libraryClient) {
        this.libraryClient = libraryClient;
    }

    @Override
    public List<BookDto> list(int page, int pageSize) {
        return libraryClient.listBooks(page, pageSize)
                .stream()
                .map(LibraryBookDto::toBookDto)
                .toList();
    }

    @Override
    public BookDto getBook(Long id) {
        return libraryClient.getBook(id)
                .toBookDto();
    }

    @Override
    public BookDto saveNew(SaveBookDto book) {
        return libraryClient.saveNewBook(
                new LibrarySaveBookDto(
                        book.toString(),
                        book.author(),
                        book.yearPublished()
                )
        ).toBookDto();
    }

    @Override
    public BookDto update(Long id, SaveBookDto book) {
        return libraryClient.updateBook(
                id,
                new LibrarySaveBookDto(
                        book.name(),
                        book.author(),
                        book.yearPublished()
                )
        ).toBookDto();
    }

    @Override
    public void delete(Long id) {
        libraryClient.deleteBook(id);
    }
}
