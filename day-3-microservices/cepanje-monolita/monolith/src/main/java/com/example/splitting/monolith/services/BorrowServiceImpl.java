package com.example.splitting.monolith.services;

import com.example.splitting.monolith.entities.Borrow;
import com.example.splitting.monolith.exceptions.NotFoundException;
import com.example.splitting.monolith.exceptions.ResourceAlreadyTakenException;
import com.example.splitting.monolith.repositories.BookRepository;
import com.example.splitting.monolith.repositories.BorrowRepository;
import com.example.splitting.monolith.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class BorrowServiceImpl implements BorrowService {

    private final BorrowRepository borrowRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BorrowServiceImpl(
            BorrowRepository borrowRepository,
            UserRepository userRepository,
            BookRepository bookRepository
    ) {
        this.bookRepository = bookRepository;
        this.borrowRepository = borrowRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Borrow borrowBook(Long bookId, Long userId) throws NotFoundException, ResourceAlreadyTakenException {
        var book = bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("book not found"));
        var borrowedAlready = borrowRepository.findByBookIdAndReturnTimeIsNull(bookId);
        if (borrowedAlready.isPresent()) {
            throw new ResourceAlreadyTakenException("book is not available yet");
        };
        var user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("user not found"));
        return borrowRepository.save(
                Borrow.builder()
                        .book(book)
                        .borrower(user)
                        .takeTime(new Date())
                        .build()
        );
    }

    @Override
    public void returnBorrowedBook(Long bookId) throws NotFoundException {
        var borrow = borrowRepository.findByBookIdAndReturnTimeIsNull(bookId).orElseThrow(
                () -> new NotFoundException("borrowed book not found")
        );
        borrow.setReturnTime(new Date());
        borrowRepository.save(borrow);
    }

    @Override
    public void returnBorrowedBookByBorrowId(Long borrowId) throws NotFoundException {
        var borrow = borrowRepository.findById(borrowId).orElseThrow(
                () -> new NotFoundException("borrow not found")
        );
        borrow.setReturnTime(new Date());
        borrowRepository.save(borrow);
    }

    @Override
    public List<Borrow> listAll(int page, int pageSize) {
        return borrowRepository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    @Override
    public List<Borrow> listForUser(Long userId, int page, int pageSize, boolean onlyNotReturned) throws NotFoundException {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException("user not found"));
        var pageRequest = onlyNotReturned ?
                PageRequest.of(page, pageSize)
                : PageRequest.of(page, pageSize, Sort.by(Sort.Order.desc("returnTime")));
        return (
                onlyNotReturned ?
                        borrowRepository.findAllByBorrowerIdAndReturnTimeIsNull(userId, pageRequest)
                        : borrowRepository.findAllByBorrowerId(userId, pageRequest)
                ).toList();
    }
}
