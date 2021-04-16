package com.cognizant.truyum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

/**
 * 
 * @author 895076
 *repository for JPA implementations on MenuItem class
 */
@Repository
public interface MenuItemDao extends JpaRepository<MenuItem, Integer>{
	 
}