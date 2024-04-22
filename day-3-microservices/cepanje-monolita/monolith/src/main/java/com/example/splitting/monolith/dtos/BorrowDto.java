package com.example.splitting.monolith.dtos;

import com.example.splitting.monolith.entities.Borrow;

import java.util.Date;

public record BorrowDto(Long id, Date takeTime, Date returnTime, BookDto book, UserDto user) {
    static public BorrowDto fromBorrow(Borrow borrow) {
        return new BorrowDto(
                borrow.getId(),
                borrow.getTakeTime(),
                borrow.getReturnTime(),
                BookDto.fromBook(borrow.getBook()),
                UserDto.fromUser(borrow.getBorrower())
        );
    }
}
