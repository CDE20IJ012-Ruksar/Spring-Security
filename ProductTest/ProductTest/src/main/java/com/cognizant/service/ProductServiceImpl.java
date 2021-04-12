package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.ProductRepository;
import com.cognizant.exception.ProductException;
import com.cognizant.model.Product;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repository;
	
	@Override
	public List<Product> getProducts() {
	log.info("started");
	log.debug("Products are : {}"+repository.findAll());
		return repository.findAll();
	}

	@Override
	public Product getProductById(int id) throws ProductException {
		log.info("started");
		log.debug("Product is : {}"+repository.findById(id).get());
		return repository.findById(id)
				.orElseThrow(()->new ProductException("Product with the id "+id+" doen't exists"));
	}

	@Override
	public String addProduct(Product e) throws ProductException {
		log.info("started");
		Optional<Product> opemp=repository.findById(e.getId());
		if(opemp.isPresent()) {
			log.debug("Already present:{}"+e);
			throw new ProductException("Product with id "+e.getId() +" alread exists");
		}else {
			repository.save(e);
			log.debug("successfully saved :{}"+e);
		}
		return e+"\n added successfully...";
	}

	@Override
	public String updateProduct(Product e) throws ProductException {
		log.info("started");
		Optional<Product> opemp=repository.findById(e.getId());
		if(!opemp.isPresent()) {
			
			throw new ProductException("Product with id "+e.getId() +" doesn't exists");
		}else {
			log.debug("Already present:{}"+e);
			Product emp=opemp.get();
			emp.setId(e.getId());
			emp.setName(e.getName());
			emp.setCtegory(e.getCtegory());
			emp.setPrice(e.getPrice());
			repository.save(e);
			log.debug("updated successfully  :{}"+e);
		}
		return e+"\n updated successfully...";
	}

	@Override
	public String deleteProductById(int id) throws ProductException {
		log.info("started");
		Optional<Product> opemp=repository.findById(id);
		if(!opemp.isPresent()) {
			log.debug("Not present:{}"+id);
			throw new ProductException("Product with id "+id +" not exists");
		}else {
			repository.deleteById(id);
			log.debug("deleted successfully :{}"+id);
		}
		return id+"\n deleted successfully...";
	}

	

}
