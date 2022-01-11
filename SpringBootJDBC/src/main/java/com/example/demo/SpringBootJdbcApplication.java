package com.example.demo;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(SpringBootJdbcApplication.class, args);
		
	}

}
