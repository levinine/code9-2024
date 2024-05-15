package com.levinine.codenine.library.repositories;

import com.levinine.codenine.library.entities.BookLoan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {

  List<BookLoan> findAllByLoaner(String loaner);
}
