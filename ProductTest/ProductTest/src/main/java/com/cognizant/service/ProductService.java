package com.cognizant.service;

import java.util.List;

import com.cognizant.exception.ProductException;
import com.cognizant.model.Product;

public interface ProductService {

	List<Product> getProducts();
	Product getProductById(int id) throws ProductException;
	String addProduct(Product e) throws ProductException;
	String updateProduct(Product e) throws ProductException;
	String deleteProductById(int id) throws ProductException;
	
}
