package com.levinine.codenine.secured.dtos;

import com.levinine.codenine.secured.entities.Book;

public record BookDto(Long id, String title, Integer yearPublished) {
    public static BookDto fromBook(Book book) {
        return new BookDto(
            book.getId(),
            book.getTitle(),
            book.getYearPublished()
        );
    }
}
