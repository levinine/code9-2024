package com.example.splitting.monolith.services;

import com.example.splitting.monolith.dtos.BorrowDto;
import com.example.splitting.monolith.exceptions.NotFoundException;
import com.example.splitting.monolith.exceptions.ResourceAlreadyTakenException;

import java.util.List;

public interface BorrowService {
    BorrowDto borrowBook(Long bookId, Long userId) throws NotFoundException, ResourceAlreadyTakenException;
    void returnBorrowedBook(Long bookId) throws NotFoundException;
    void returnBorrowedBookByBorrowId(Long borrowId) throws NotFoundException;
    List<BorrowDto> listAll(int page, int pageSize);
    List<BorrowDto> listForUser(Long userId, int page, int pageSize, boolean onlyNotReturned) throws NotFoundException;
}
