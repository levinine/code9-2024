package com.example.splitting.monolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.splitting.monolith.repositories")
public class MonolithApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonolithApplication.class, args);
	}

	/*
	 * Migrate Books (entity, repository, service) to library-service
	 * Migrate Borrows (entity, repository, service) to library-service
	 *   Keep in mind you can't migrate borrower as well, just user ID
	 * Create library client
	 *   Make package clients.library
	 *   Implement library feign client with all the functionalities needed for books and borrows
	 *   Make package clients.dtos
	 *   Write records that will serve as DTOs
	 *   Make sure DTOs you send from this client are the same as those received by the library
	 * Reroute service to use library feign client instead of repositories
	 * Delete BookRepository and BorrowRepository
	 * Delete entities Book and Borrow
	 */
}
