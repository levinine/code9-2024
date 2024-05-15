package com.example.splitting.monolith.services;

import com.example.splitting.monolith.clients.dtos.LibraryBorrowDto;
import com.example.splitting.monolith.clients.library.LibraryClient;
import com.example.splitting.monolith.dtos.BorrowDto;
import com.example.splitting.monolith.entities.User;
import com.example.splitting.monolith.exceptions.NotFoundException;
import com.example.splitting.monolith.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BorrowServiceImpl implements BorrowService {

    private final UserRepository userRepository;
    private final LibraryClient libraryClient;

    @Autowired
    public BorrowServiceImpl(
            UserRepository userRepository,
            LibraryClient libraryClient
    ) {
        this.userRepository = userRepository;
        this.libraryClient = libraryClient;
    }

    @Override
    public BorrowDto borrowBook(Long bookId, Long userId) throws NotFoundException {
        var borrow = libraryClient.borrowBook(bookId, userId);
        var user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("user not found"));
        return borrow.toBorrowDto(user);
    }

    @Override
    public void returnBorrowedBook(Long bookId) {
        libraryClient.forceReturnBook(bookId);
    }

    @Override
    public void returnBorrowedBookByBorrowId(Long borrowId) {
        libraryClient.returnBook(borrowId);
    }

    private Map<Long, User> getUsersByIds(List<Long> ids) {
        return userRepository.findByIdIn(ids)
                .stream()
                .collect(Collectors.toMap(
                        User::getId,
                        user -> user
                ));
    }

    @Override
    public List<BorrowDto> listAll(int page, int pageSize) {
        var borrows = libraryClient.listBorrows(page, pageSize);
        var userIds = borrows.stream().map(LibraryBorrowDto::userId).toList();
        var users = getUsersByIds(userIds);
        return borrows.stream()
                .map(borrow -> borrow.toBorrowDto(users.get(borrow.userId())))
                .toList();
    }

    @Override
    public List<BorrowDto> listForUser(Long userId, int page, int pageSize, boolean onlyNotReturned) throws NotFoundException {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException("user not found"));
        return libraryClient.listUserBorrows(userId, page, pageSize, onlyNotReturned)
                .stream()
                .map(borrow -> borrow.toBorrowDto(null))
                .toList();
    }
}
