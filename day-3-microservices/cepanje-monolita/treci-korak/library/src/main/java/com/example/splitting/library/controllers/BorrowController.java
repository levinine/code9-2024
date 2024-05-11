package com.example.splitting.library.controllers;

import com.example.splitting.library.dtos.BorrowDto;
import com.example.splitting.library.exceptions.NotFoundException;
import com.example.splitting.library.exceptions.ResourceAlreadyTakenException;
import com.example.splitting.library.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1")
public class BorrowController {

    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping(path = "/borrows", produces = MediaType.APPLICATION_JSON_VALUE)
    List<BorrowDto> listBorrows(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "page-size", defaultValue = "10") Integer pageSize
    ) {
        return borrowService.listAll(page, pageSize)
                .stream()
                .map(BorrowDto::fromBorrow)
                .toList();
    }

    @GetMapping(path = "/users/{userId}/borrows", produces = MediaType.APPLICATION_JSON_VALUE)
    List<BorrowDto> listUserBorrows(
            @PathVariable(name = "userId") Long userId,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "page-size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "only-not-returned", defaultValue = "false") Boolean onlyNotReturned
    ) throws NotFoundException {
        return borrowService.listForUser(userId, page, pageSize, onlyNotReturned)
                .stream()
                .map(BorrowDto::fromBorrow)
                .toList();
    }

    @PostMapping(path = "/books/{bookId}/borrow-by/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    BorrowDto borrowBook(
            @PathVariable(name = "bookId") Long bookId,
            @PathVariable(name = "userId") Long userId
    ) throws NotFoundException, ResourceAlreadyTakenException {
        var borrow = borrowService.borrowBook(bookId, userId);
        return BorrowDto.fromBorrow(borrow);
    }

    @DeleteMapping(path = "/borrow/{id}")
    void returnBook(@PathVariable(name = "id") Long id) throws NotFoundException {
        borrowService.returnBorrowedBookByBorrowId(id);
    }

    @PostMapping(path = "/book/{id}/force-return")
    void forceReturnBook(@PathVariable(name = "id") Long id) throws NotFoundException {
        borrowService.returnBorrowedBook(id);
    }
}
