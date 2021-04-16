package com.cognizant.truyum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.User;

/**
 * 
 * @author 895076
 *repository for JPA implementations on User class
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	 
}