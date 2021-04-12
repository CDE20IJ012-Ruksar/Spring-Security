package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.ProductException;
import com.cognizant.model.Product;
import com.cognizant.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable("id") int id) throws ProductException{
		return service.getProductById(id);
	}
	
	@PostMapping("/add")
	public String addProduct(@RequestBody Product p) throws ProductException{
		return service.addProduct(p);
	}
	
	@PutMapping("/update")
	public String updateProduct(@RequestBody Product p) throws ProductException{
		return service.updateProduct(p);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) throws ProductException{
		return service.deleteProductById(id);
	}
	
}
