package com.levinine.concert.monolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConcertServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcertServiceApplication.class, args);
	}

}
