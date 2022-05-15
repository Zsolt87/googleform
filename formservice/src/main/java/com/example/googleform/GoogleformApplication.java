package com.example.googleform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GoogleformApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleformApplication.class, args);
	}

}
