package com.bafoly.pagination;

import java.util.stream.IntStream;

import com.bafoly.pagination.user.User;
import com.bafoly.pagination.user.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaginationApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository){
		return args -> IntStream.rangeClosed(1, 30).forEach(i -> {
			User user = new User();
			user.setUsername("user-" + i);
			user.setEmail("user" + i + "@mail.com");
			user.setPassword("password");
			userRepository.save(user);
		});
		
	}

}
