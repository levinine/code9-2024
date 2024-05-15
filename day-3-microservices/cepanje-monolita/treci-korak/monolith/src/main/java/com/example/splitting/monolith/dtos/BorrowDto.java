package com.example.splitting.monolith.dtos;

import java.util.Date;

public record BorrowDto(Long id, Date takeTime, Date returnTime, BookDto book, UserDto user) {
}
