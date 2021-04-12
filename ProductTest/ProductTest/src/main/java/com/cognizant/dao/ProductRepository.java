package com.cognizant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
