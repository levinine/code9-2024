package com.levinine.codenine.secured;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.levinine.codenine.secured.repositories")
public class SecuredApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredApplication.class, args);
	}

}
