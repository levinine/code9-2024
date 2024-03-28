package com.levinine.codenine.secured.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.levinine.codenine.secured.entities.Book;
import com.levinine.codenine.secured.exceptions.NotFoundException;
import com.levinine.codenine.secured.repositories.BookRepository;

@Component
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveNew(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) throws NotFoundException{
        var book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new NotFoundException("book not found");
        }
        bookRepository.deleteById(id);
    }
}
