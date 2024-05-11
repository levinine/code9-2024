package com.example.splitting.monolith.clients.dtos;

import com.example.splitting.monolith.dtos.BorrowDto;
import com.example.splitting.monolith.dtos.UserDto;
import com.example.splitting.monolith.entities.User;

import java.util.Date;

public record LibraryBorrowDto(Long id, Date takeTime, Date returnTime, LibraryBookDto book, Long userId) {
    public BorrowDto toBorrowDto(User user) {
        return new BorrowDto(
                this.id,
                this.takeTime,
                this.returnTime,
                book.toBookDto(),
                UserDto.fromUser(user)
        );
    }
}