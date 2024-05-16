package com.levinine.codenine.library.controller;


import com.levinine.codenine.library.dto.LibraryMemberLoansDto;
import com.levinine.codenine.library.service.BookLoanService;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-loans")
@AllArgsConstructor
public class BookLoanController {

  private final BookLoanService bookLoanService;

  @GetMapping
  public LibraryMemberLoansDto findAllByLibraryCardId(
      @RequestParam @NotBlank final String libraryCardId) {
    return bookLoanService.findAllByLibraryCardId(libraryCardId);
  }

}
