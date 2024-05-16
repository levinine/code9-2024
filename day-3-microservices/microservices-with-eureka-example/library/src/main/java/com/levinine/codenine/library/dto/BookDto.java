package com.levinine.codenine.library.dto;

import com.levinine.codenine.library.entity.Book;

public record BookDto(Long id, String title, Integer yearPublished) {

    public static BookDto fromBook(Book book) {
        return new BookDto(book.getId(), book.getName(), book.getYearPublished());
    }
}
