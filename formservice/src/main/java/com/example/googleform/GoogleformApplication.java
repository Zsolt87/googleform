package com.example.googleform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableScheduling
@EnableWebSecurity
@SpringBootApplication
public class GoogleformApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleformApplication.class, args);
	}

}
