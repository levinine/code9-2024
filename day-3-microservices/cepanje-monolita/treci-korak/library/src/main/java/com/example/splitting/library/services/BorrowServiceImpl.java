package com.example.splitting.library.services;

import com.example.splitting.library.entities.Borrow;
import com.example.splitting.library.exceptions.NotFoundException;
import com.example.splitting.library.exceptions.ResourceAlreadyTakenException;
import com.example.splitting.library.repositories.BookRepository;
import com.example.splitting.library.repositories.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class BorrowServiceImpl implements BorrowService {

    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BorrowServiceImpl(
            BorrowRepository borrowRepository,
            BookRepository bookRepository
    ) {
        this.bookRepository = bookRepository;
        this.borrowRepository = borrowRepository;
    }

    @Override
    public Borrow borrowBook(Long bookId, Long userId) throws NotFoundException, ResourceAlreadyTakenException {
        var book = bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("book not found"));
        var borrowedAlready = borrowRepository.findByBookIdAndReturnTimeIsNull(bookId);
        if (borrowedAlready.isPresent()) {
            throw new ResourceAlreadyTakenException("book is not available yet");
        }
        return borrowRepository.save(
                Borrow.builder()
                        .book(book)
                        .borrowerId(userId)
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
