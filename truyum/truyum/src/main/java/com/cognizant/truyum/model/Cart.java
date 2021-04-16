package com.cognizant.truyum.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


/**
 * 
 * @author 895076
 *model class for cart table
 */
@Data
@Entity
@Table(name="cart")
public class Cart {	
	@Id
	@Column(name="ct_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="ct_us_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="ct_pr_id")
	private MenuItem menuItem;
	
	public Cart( int id,User user, MenuItem menuItem) {
		super();
		this.id=id;
		this.user = user;
		this.menuItem = menuItem;
	}
	
	
	public Cart() {
		super();
	}


	public Cart(User user) {
		super();
		this.user = user;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public MenuItem getMenuItem() {
		return menuItem;
	}
	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}
}
