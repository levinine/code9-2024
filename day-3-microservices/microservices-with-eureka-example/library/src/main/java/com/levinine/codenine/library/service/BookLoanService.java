package com.levinine.codenine.library.service;

import com.levinine.codenine.library.client.UserProfileServiceClient;
import com.levinine.codenine.library.dto.BookLoanDto;
import com.levinine.codenine.library.dto.LibraryMemberLoansDto;
import com.levinine.codenine.library.repository.BookLoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookLoanService {

  private final BookLoanRepository bookLoanRepository;
  private final UserProfileServiceClient userProfileServiceClient;

  public LibraryMemberLoansDto findAllByLibraryCardId(final String libraryCardId) {
    final var userProfileDto = userProfileServiceClient
        .findUserProfileByLibraryCardId(libraryCardId);

    final var bookLoans = bookLoanRepository.findAllByLibraryCardId(libraryCardId)
            .stream()
            .map(BookLoanDto::fromBookLoan)
            .toList();

    return LibraryMemberLoansDto.map(userProfileDto, bookLoans);
  }
}
