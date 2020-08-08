package com.uttara.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages= {"com.uttara.repositories"}) // for repository scannings
@EntityScan(basePackages= {"com.uttara.beans"}) // for entity scannings
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages= {"com.uttara.services","com.uttara.controllers","com.uttara.todo","com.uttara.repositories","com.uttara.beans"})
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}
