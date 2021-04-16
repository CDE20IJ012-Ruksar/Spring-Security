package com.cognizant.truyum.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFound;
import com.cognizant.truyum.exception.UserNotFound;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/cart")
public class CartController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class); 
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartDao cartDao;
	
	/*@GetMapping("")
	public List<MenuItem> getAllMenuItems(){
		 LOGGER.info("started fetching all items");
		 LOGGER.debug("Items are : {}"+menuItemService.getMenuItemListCustomer());
		 return menuItemService.getMenuItemListCustomer();
	}*/
	
	@GetMapping("/itemList/{userId}")
	public MenuItem getAllCartItems(@PathVariable int userId ) throws CartEmptyException{
		LOGGER.info("started to fetch item with id");
		MenuItem menuItem= cartService.getAllCartItems(userId);
		return menuItem;
	}
	
	@PostMapping("/{userId}/{menuItemId}")
	public Cart addCartItem(@PathVariable int userId,@PathVariable int menuItemId ) throws MenuItemNotFound, UserNotFound{
		LOGGER.info("started to add cart item");
		LOGGER.debug("Item added");
		return cartService.addCartItem(userId, menuItemId);
	}
}
