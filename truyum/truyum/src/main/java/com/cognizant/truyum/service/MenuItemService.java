package com.cognizant.truyum.service;

import java.util.List;
import java.util.Optional;
import com.cognizant.truyum.exception.MenuItemNotFound;
import com.cognizant.truyum.model.MenuItem;

/**
 * 
 * @author 895076
 *MenuItemService has 3 abstract methods
 */
public interface MenuItemService  {
	/**
	 * 
	 * @return list of menu items
	 */
	public List<MenuItem> getMenuItemListCustomer();
	
	/**
	 * 
	 * @param id
	 * @return list based on menu item id
	 * @throws MenuItemNotFound
	 */
	public Optional<MenuItem> getMenuItem(int id) throws MenuItemNotFound;
		
	/**
	 * 
	 * @param menuItem
	 * @return modified list
	 * @throws MenuItemNotFound
	 */
	public String modifyMenuItem(MenuItem menuItem) throws MenuItemNotFound;


}
