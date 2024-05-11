package com.example.splitting.library.services;

import com.example.splitting.library.dtos.SaveBookDto;
import com.example.splitting.library.entities.Book;
import com.example.splitting.library.exceptions.NotFoundException;
import com.example.splitting.library.repositories.BookRepository;
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
    public List<Book> list(int page, int pageSize) {
        return bookRepository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveNew(SaveBookDto book) {
        var bookToSave = Book.builder()
                .name(book.name())
                .author(book.author())
                .yearPublished(book.yearPublished())
                .build();
        return bookRepository.save(bookToSave);
    }

    @Override
    public Book update(Long id, SaveBookDto book) throws NotFoundException {
        var bookToChange = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("book not found"));
        bookToChange.setName(book.name());
        bookToChange.setAuthor(book.author());
        bookToChange.setYearPublished(book.yearPublished());
        return bookRepository.save(bookToChange);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        var book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new NotFoundException("book not found");
        }
        bookRepository.delete(book.get());
    }
}
