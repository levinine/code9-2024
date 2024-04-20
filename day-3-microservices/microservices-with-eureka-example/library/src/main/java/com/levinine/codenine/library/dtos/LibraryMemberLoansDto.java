package com.levinine.codenine.library.dtos;

import java.util.List;

public record LibraryMemberLoansDto(UserProfileDto userProfileDto, List<BookLoanDto> bookLoanDtos) {

  public static LibraryMemberLoansDto map(UserProfileDto userProfileDto, List<BookLoanDto> bookLoanDtos) {
    return new LibraryMemberLoansDto(userProfileDto, bookLoanDtos);
  }

}
