package com.example.splitting.library.services;

import com.example.splitting.library.entities.Borrow;
import com.example.splitting.library.exceptions.NotFoundException;
import com.example.splitting.library.exceptions.ResourceAlreadyTakenException;

import java.util.List;

public interface BorrowService {
    Borrow borrowBook(Long bookId, Long userId) throws NotFoundException, ResourceAlreadyTakenException;
    void returnBorrowedBook(Long bookId) throws NotFoundException;
    void returnBorrowedBookByBorrowId(Long borrowId) throws NotFoundException;
    List<Borrow> listAll(int page, int pageSize);
    List<Borrow> listForUser(Long userId, int page, int pageSize, boolean onlyNotReturned) throws NotFoundException;
}
