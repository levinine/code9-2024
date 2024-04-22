package com.example.splitting.monolith.dtos;

import java.util.Date;

public record BorrowListItemDto(Long id, Date takeTime, Date returnTime, Long bookId, Long userId) {
}
