package com.example.googleform;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.3.1")
class GoogleformApplicationTests {

	@Test
	void contextLoads() {
	}

}
