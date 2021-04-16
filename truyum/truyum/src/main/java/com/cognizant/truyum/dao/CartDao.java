package com.cognizant.truyum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

/**
 * 
 * @author 895076
 *repository for JPA implementations on Cart class
 */
@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{
	 
	@Query("select c.id from Cart c where c.user.userId=:userId")
	public List<Integer> getAllCartItems(@Param("userId") int userId);
	
	
	 
}