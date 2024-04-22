package com.example.splitting.monolith.dtos;

import com.example.splitting.monolith.entities.Book;

public record BookDto(Long id, String name, String author, Integer yearPublished) {
    static public BookDto fromBook(Book book) {
        return new BookDto(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getYearPublished()
        );
    }
}
