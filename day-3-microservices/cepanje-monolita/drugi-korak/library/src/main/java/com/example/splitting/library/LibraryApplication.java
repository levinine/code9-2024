package com.example.splitting.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	/*
	 * Make Book and Borrow entities
	 * Migrate liquibase for books and borrows
	 * Make repositories for those entities
	 *   BorrowRepository already has some code to help you out
	 * Make services for Book and Borrow entities
	 * Go to controllers.DefaultControllerAdvice
	 *   Make exception handlers for exceptions in the exceptions package
	 * Make controllers for books and borrows
	 * Feel free to copy/paste as much code as you can from monolith
	 *   If needed, adjust the code to suite new function
	 */

}
