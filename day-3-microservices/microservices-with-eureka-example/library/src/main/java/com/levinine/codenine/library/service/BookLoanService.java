package com.levinine.codenine.library.service;

import com.levinine.codenine.library.client.UserProfileServiceClient;
import com.levinine.codenine.library.dto.BookLoanDto;
import com.levinine.codenine.library.dto.LibraryMemberLoansDto;
import com.levinine.codenine.library.dto.UserProfileDto;
import com.levinine.codenine.library.repository.BookLoanRepository;
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
