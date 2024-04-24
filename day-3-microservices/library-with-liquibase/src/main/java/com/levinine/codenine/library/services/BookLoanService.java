package com.levinine.codenine.library.services;

import com.levinine.codenine.library.dtos.BookLoanDto;
import com.levinine.codenine.library.repositories.BookLoanRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookLoanService {

  private final BookLoanRepository bookLoanRepository;

  public List<BookLoanDto> findAllByLoaner(String loaner) {

    return bookLoanRepository.findAllByLoaner(loaner)
            .stream()
            .map(BookLoanDto::fromBookLoan)
            .collect(Collectors.toList());
  }
}
