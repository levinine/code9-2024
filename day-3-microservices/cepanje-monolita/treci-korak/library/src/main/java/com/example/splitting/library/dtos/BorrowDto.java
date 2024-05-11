package com.example.splitting.library.dtos;

import com.example.splitting.library.entities.Borrow;

import java.util.Date;

public record BorrowDto(Long id, Date takeTime, Date returnTime, BookDto book, Long userId) {
    static public BorrowDto fromBorrow(Borrow borrow) {
        return new BorrowDto(
                borrow.getId(),
                borrow.getTakeTime(),
                borrow.getReturnTime(),
                BookDto.fromBook(borrow.getBook()),
                borrow.getBorrowerId()
        );
    }
}
