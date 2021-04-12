package com.cognizant;


import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AutoConfigMockMvcTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testGreet() throws Exception {
		this.mockMvc.perform(get("/greet"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content()
		.string(containsString("Welcome to spring")));
	}
}