package com.cognizant.truyum.service;

import java.util.List;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFound;
import com.cognizant.truyum.exception.UserNotFound;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

/**
 * 
 * @author 895076
 *CartService class has 3 abstract methods
 */
public interface CartService {
	/**
	 * 
	 * @param userId
	 * @param menuItemId
	 * @return new entry of cart
	 * @throws MenuItemNotFound
	 * @throws UserNotFound
	 */
	public Cart addCartItem(int userId, int menuItemId)  throws MenuItemNotFound,UserNotFound;
	
	/**
	 * it removes cart id with userId and menuItemId
	 * @param userId
	 * @param menuItemId
	 */
	public void removeCartItem(long userId, long menuItemId);
	
	/**
	 * 
	 * @param userId
	 * @return a list of menu items for that particular userId
	 */
	public MenuItem getAllCartItems(int userId);
}