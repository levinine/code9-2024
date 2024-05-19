package com.levinine.codenine.library.service;

import com.levinine.codenine.library.dto.BookLoanDto;
import com.levinine.codenine.library.dto.LibraryMemberLoansDto;
import com.levinine.codenine.library.dto.UserProfileDto;
import com.levinine.codenine.library.repository.BookLoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookLoanService {

  private final BookLoanRepository bookLoanRepository;

  public LibraryMemberLoansDto findAllByLibraryCardId(final String libraryCardId) {

    // TODO: replace this line with call to user-profile-service
    final var userProfileDto = new UserProfileDto("John", "Doe", "unknown 34", "555-333");

    final var bookLoans = bookLoanRepository.findAllByLibraryCardId(libraryCardId)
            .stream()
            .map(BookLoanDto::fromBookLoan)
            .toList();

    return LibraryMemberLoansDto.map(userProfileDto, bookLoans);
  }
}
