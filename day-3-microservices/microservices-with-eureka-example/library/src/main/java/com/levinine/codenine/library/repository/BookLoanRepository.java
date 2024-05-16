package com.levinine.codenine.library.repository;

import com.levinine.codenine.library.entity.BookLoan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {

  List<BookLoan> findAllByLibraryCardId(String libraryCardId);
}
