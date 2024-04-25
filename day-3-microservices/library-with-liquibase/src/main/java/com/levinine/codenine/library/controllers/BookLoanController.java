package com.levinine.codenine.library.controllers;


import com.levinine.codenine.library.dtos.BookLoanDto;
import com.levinine.codenine.library.services.BookLoanService;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
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
  public List<BookLoanDto> findAllByLoaner(
      @RequestParam @NotBlank String loaner) {
    return bookLoanService.findAllByLoaner(loaner);
  }

}
