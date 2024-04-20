package com.levinine.codenine.library.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.levinine.codenine.library.entities.BookLoan;
import java.time.LocalDate;

@JsonInclude(Include.NON_NULL)
public record BookLoanDto(Long Id, BookDto bookDto, LocalDate reserveDate, LocalDate dueDate,
                          LocalDate returnDate) {

  public static BookLoanDto fromBookLoan(BookLoan bookLoan) {
    return new BookLoanDto(bookLoan.getId(), BookDto.fromBook(bookLoan.getBook()),
        bookLoan.getReserveDate(), bookLoan.getDueDate(), bookLoan.getReturnDate());
  }

}
