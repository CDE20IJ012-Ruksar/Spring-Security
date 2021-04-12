package com.cognizant;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest
@AutoConfigureMockMvc
class ProductTestApplicationTests {

	@Autowired
	private MockMvc mock;
	@Test
	void contextLoads() {
		assertThat(mock).isNotNull();
	}
	
	@Test
	public void testGetProducts() throws Exception {
		this.mock.perform(get("/products")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$[*]", hasSize(5)));
		
	}
	
	@Test
	public void testGetProduct() throws Exception {
		this.mock.perform(get("/products/10")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.id").value(10))
		.andExpect(jsonPath("$.name").value("mi"))
		.andExpect(jsonPath("$.ctegory").value("mobile"))
		.andExpect(jsonPath("$.price").value(150000));
		
	}
	@Test
	public void testGetProductswithData() throws Exception {
		this.mock.perform(get("/products")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$[*]", hasSize(5)))
		.andExpect(jsonPath("$[0].id").value(10))
		.andExpect(jsonPath("$[0].name").value("mi"))
		.andExpect(jsonPath("$[0].ctegory").value("mobile"))
		.andExpect(jsonPath("$[0].price").value(150000));
		
	}
	
	@Test
	public void testGetProductNegative()  {
		try {
			this.mock.perform(get("/products/1110")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound())
			.andDo(print())
			.andExpect(content().string("Product with the id 1110 doen't exists"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testDeleteProductNegative()  {
		try {
			this.mock.perform(delete("/delete/1110")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound())
			.andDo(print())
			.andExpect(content().string("Product with the id 1110 not exists"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//@Test
	public void testDeleteProduct()  {
		try {
			this.mock.perform(delete("/delete/40"))
			.andExpect(status().isOk())
			.andExpect(content().string("40\n deleted successfully..."));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testAddProduct() throws Exception{
		Product p=new Product(45, "tab", "LG", 10000);
		
		ObjectMapper  mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow=mapper.writer().withDefaultPrettyPrinter();
		String requestJson=ow.writeValueAsString(p);
		mock.perform(post("/add").contentType("application/json")
		.content(requestJson))
		.andExpect(status().isOk());
		
	}
}
