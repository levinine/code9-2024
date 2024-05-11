package com.example.splitting.monolith.controllers;

import com.example.splitting.monolith.dtos.BorrowDto;
import com.example.splitting.monolith.entities.User;
import com.example.splitting.monolith.exceptions.NotFoundException;
import com.example.splitting.monolith.exceptions.ResourceAlreadyTakenException;
import com.example.splitting.monolith.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "/v1")
public class BorrowController {

    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/borrows", produces = MediaType.APPLICATION_JSON_VALUE)
    List<BorrowDto> listBorrows(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "page-size", defaultValue = "10") Integer pageSize
    ) {
        return borrowService.listAll(page, pageSize);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(path = "/me/borrows", produces = MediaType.APPLICATION_JSON_VALUE)
    List<BorrowDto> listUserBorrows(
            Principal principal,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "page-size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "only-not-returned", defaultValue = "false") Boolean onlyNotReturned
    ) throws NotFoundException {
        var userId = ((User)principal).getId();
        return borrowService.listForUser(userId, page, pageSize, onlyNotReturned);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping(path = "/books/{bookId}/borrow", produces = MediaType.APPLICATION_JSON_VALUE)
    BorrowDto borrowBook(
            Principal principal,
            @PathVariable(name = "bookId") Long bookId
    ) throws NotFoundException, ResourceAlreadyTakenException {
        var userId = ((User)principal).getId();
        return borrowService.borrowBook(bookId, userId);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping(path = "/borrow/{id}")
    void returnBook(@PathVariable(name = "id") Long id) throws NotFoundException {
        borrowService.returnBorrowedBookByBorrowId(id);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/book/{id}/force-return")
    void forceReturnBook(@PathVariable(name = "id") Long id) throws NotFoundException {
        borrowService.returnBorrowedBook(id);
    }
}
