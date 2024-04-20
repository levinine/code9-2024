package com.levinine.codenine.library.dtos;

import java.util.List;

public record LibraryMemberLoansDto(UserProfileDto userProfile, List<BookLoanDto> bookLoans) {

  public static LibraryMemberLoansDto map(UserProfileDto userProfile, List<BookLoanDto> bookLoans) {
    return new LibraryMemberLoansDto(userProfile, bookLoans);
  }

}
