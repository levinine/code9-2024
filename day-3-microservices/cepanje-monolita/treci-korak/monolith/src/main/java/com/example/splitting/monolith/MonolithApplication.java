package com.example.splitting.monolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.splitting.monolith.repositories")
@EnableFeignClients
public class MonolithApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonolithApplication.class, args);
	}

}

/*
 * WHAT TO DO?
 * Go to src/main/resources directory
 * Make a file bootstrap.yml
 *   Check microservices-with-eureka demo to see the contents of such file.
 *   Copy contents and deduce what changes should be made
 * Make a file Dockerfile at project root
 *   Check microservices-with-eureka demo to see how Dockerfile should look like
 *   Make changes accordingly
 * Copy eureka service to directory treci-korak (go to terminal, go to project root and execute "cp -r <eureka_path> <treci-korak-dir-path>")
 * Make a file docker-compose.yml in <treci-korak-dir-path>
 *   Check microservices-with-eureka demo to see how docker-compose.yml should look like
 *   Make changes accordingly
 * Make a file Makefile in <treci-korak-dir-path>
 *   Check microservices-with-eureka demo to see how Makefile should look like
 *   Make changes accordingly
 * Run command "make dev" to spin up new microservices
 * If things are not working as they should here are some commands to figure out what is missing:
 *   "docker images" - list all images
 *   "docker ps" - list all running containers created from before mentioned images
 *   "docker ps -a" - list all containers created from before mentioned images (maybe container crashed)
 */