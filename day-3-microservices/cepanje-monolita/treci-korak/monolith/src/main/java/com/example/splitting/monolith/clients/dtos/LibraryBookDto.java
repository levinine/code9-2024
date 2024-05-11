package com.example.splitting.monolith.clients.dtos;

import com.example.splitting.monolith.dtos.BookDto;

public record LibraryBookDto(Long id, String name, String author, Integer yearPublished) {
    public BookDto toBookDto() {
        return new BookDto(
                this.id,
                this.name,
                this.author,
                this.yearPublished
        );
    }
}
