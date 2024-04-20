package com.levinine.codenine.library.controllers;


import com.levinine.codenine.library.dtos.LibraryMemberLoansDto;
import com.levinine.codenine.library.services.BookLoanService;
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
      @RequestParam @NotBlank String libraryCardId) {
    return bookLoanService.findAllByLibraryCardId(libraryCardId);
  }

}
