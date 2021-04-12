package com.cognizant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloTestApplicationTests {

	@Autowired
	HelloController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
