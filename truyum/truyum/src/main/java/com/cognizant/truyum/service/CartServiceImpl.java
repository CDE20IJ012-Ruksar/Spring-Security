package com.cognizant.truyum.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.UserDao;
import com.cognizant.truyum.exception.MenuItemNotFound;
import com.cognizant.truyum.exception.UserNotFound;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;

/**
 * 
 * @author 895076
 *CartServiceImpl class has 3 implemented methods
 */
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private MenuItemDao menuItemDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	
	int c=0;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class); 
	
	
	@Transactional
	@Override
	/**
	 * @return new entry of cart
	 */
	public Cart addCartItem(int userId, int menuItemId) throws MenuItemNotFound, UserNotFound {
		// TODO Auto-generated method stub
		LOGGER.info("started adding item to cart");
		c=c+1;
		Cart cart=null;
		LOGGER.debug("start");
		Optional<MenuItem> item=menuItemDao.findById(menuItemId);
		Optional<User> user=userDao.findById(userId);
		if(!item.isPresent()) {
			LOGGER.debug("menu item is not present");
			throw new MenuItemNotFound("Item with id "+menuItemId+ "does not exist");
		}
		else if(!item.isPresent()) {
			LOGGER.debug("user id not does not exist");
			throw new UserNotFound("User with id "+userId+ "does not exist");
		}
		else
		{
			cart=new Cart(c,user.get(),item.get());
			cartDao.save(cart);
			LOGGER.debug("item added");
			LOGGER.debug("end");
		}
		
		return cart;
	}

	
	@Override
	@Transactional
	/**
	 * it removes cart id with userId and menuItemId
	 */
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	/**
	 * @return a list of menu items for that particular userId
	 */
	public MenuItem getAllCartItems(int userId){
		List<Integer> cartt=cartDao.getAllCartItems(userId);
		Cart cart=cartDao.findById(cartt).get();
		return cart.getMenuItem();
	}







	

	
}
