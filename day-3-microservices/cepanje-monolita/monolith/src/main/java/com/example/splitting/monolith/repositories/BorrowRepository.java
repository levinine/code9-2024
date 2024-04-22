package com.example.splitting.monolith.repositories;

import com.example.splitting.monolith.entities.Borrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface BorrowRepository extends PagingAndSortingRepository<Borrow, Long>, JpaRepository<Borrow, Long> {
    Optional<Borrow> findByBookIdAndReturnTimeIsNull(Long bookId);
    Page<Borrow> findAllByBorrowerId(Long userId, Pageable pageable);
    Page<Borrow> findAllByBorrowerIdAndReturnTimeIsNull(Long userId, Pageable pageable);
}

