package com.bananaback.SpringDataJPAHibernatePractice;

import com.bananaback.SpringDataJPAHibernatePractice.Services.TestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaHibernatePracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaHibernatePracticeApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(TestService testService) {
		return args -> {
			testService.testCRUD();
		};
	}
}
