package com.levinine.codenine.library.services;

import com.levinine.codenine.library.client.UserProfileServiceClient;
import com.levinine.codenine.library.dtos.BookLoanDto;
import com.levinine.codenine.library.dtos.LibraryMemberLoansDto;
import com.levinine.codenine.library.dtos.UserProfileDto;
import com.levinine.codenine.library.repositories.BookLoanRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookLoanService {

  private final BookLoanRepository bookLoanRepository;
  private final UserProfileServiceClient userProfileServiceClient;

  public LibraryMemberLoansDto findAllByLibraryCardId(String libraryCardId) {
    UserProfileDto userProfileDto = userProfileServiceClient
        .findUserProfileByLibraryCardId(libraryCardId);

    List<BookLoanDto> bookLoans =
        bookLoanRepository.findAllByLibraryCardId(libraryCardId)
            .stream()
            .map(BookLoanDto::fromBookLoan)
            .collect(Collectors.toList());

    return LibraryMemberLoansDto.map(userProfileDto, bookLoans);
  }
}
