package com.example.splitting.monolith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MonolithApplicationTests {

	record MyObj(String name, Integer age, Boolean active) {}

	@Test
	void contextLoads() {
	}

}
