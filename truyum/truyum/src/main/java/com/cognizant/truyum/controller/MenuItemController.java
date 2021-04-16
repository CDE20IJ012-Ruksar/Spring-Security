package com.cognizant.truyum.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.truyum.exception.MenuItemNotFound;
import com.cognizant.truyum.model.MenuItem;

import com.cognizant.truyum.service.MenuItemService;

/**
 * 
 * @author 895076
 *MenuItemController class has 3 functionalities
 *
 */
@RestController
@RequestMapping("/menu_items")
public class MenuItemController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class); 
	@Autowired
	private MenuItemService menuItemService;
	
	/**
	 * 
	 * @return list of all items in list
	 */
	@GetMapping("/show-menu-list-admin")
	public List<MenuItem>  showMenuItemListAdmin(){
		 LOGGER.info("started fetching all items");
		 LOGGER.debug("Items are : {}"+menuItemService.getMenuItemListCustomer());
		 return menuItemService.getMenuItemListCustomer();
	}
	
	/**
	 * 
	 * @param id
	 * @return list based on item id
	 * @throws MenuItemNotFound
	 */
	@GetMapping("/show-menu-item/{id}")
	public Optional<MenuItem> showMenuItem(@PathVariable("id") int id) throws MenuItemNotFound{
		LOGGER.info("started to fetch item with id");
		Optional<MenuItem> item= menuItemService.getMenuItem(id);
		LOGGER.debug("Item is:{}"+item);
		return item;
	}
	
	/**
	 * 
	 * @param menuItem
	 * @return edited menu list based on the changes we specify in request body
	 * @throws MenuItemNotFound
	 */
	@PutMapping("/edit-menu-item")
	public String editMenuItem(@Valid @RequestBody MenuItem menuItem) throws MenuItemNotFound {
		LOGGER.info("started to update item");
		LOGGER.debug("Item is: {}"+menuItem);
		return menuItemService.modifyMenuItem(menuItem);
	}
}
