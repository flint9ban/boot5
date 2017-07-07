package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.persistence.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository userRepository){
		return strings -> {
				Arrays.asList("john,jim,kate,tom,jacky".split(","))
						.stream().map(name->new User(name))
						.forEach(userRepository::save);
				userRepository.findAll().stream().forEach(System.out::println);
		};


	}
}
