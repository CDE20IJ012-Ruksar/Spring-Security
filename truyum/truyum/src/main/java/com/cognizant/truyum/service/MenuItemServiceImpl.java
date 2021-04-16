package com.cognizant.truyum.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.controller.MenuItemController;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.exception.MenuItemNotFound;
import com.cognizant.truyum.model.MenuItem;


/**
 * 
 * @author 895076
 *MenuItemServiceImpl class has 3 implemented methods
 */
@Service
public class MenuItemServiceImpl implements MenuItemService{
	@Autowired
	private MenuItemDao menuItemDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemServiceImpl.class); 
	
	/**
	 * @return list of menu items
	 */
	@Override
	public List<MenuItem> getMenuItemListCustomer(){
		 LOGGER.info("started service for getting all items");
		 LOGGER.debug("Items are : {}"+menuItemDao.findAll());
		 return menuItemDao.findAll();
	}
	
	/**
	 * @return list based on menu item id
	 */
	@Override
	public Optional<MenuItem> getMenuItem(int id) throws MenuItemNotFound{
		LOGGER.info("started service for getting item with id");
		Optional<MenuItem> item=menuItemDao.findById(id);
		if(item.isPresent()) {
		LOGGER.debug("Items are : {}"+item);}
		else {
			throw new MenuItemNotFound("Item with id "+id+ "does not exist");
		}
		return item;
				
	}
	
	/**
	 * @return modified list
	 */
	@Override
	public String modifyMenuItem(MenuItem menuItem) throws MenuItemNotFound {
		// TODO Auto-generated method stub
		LOGGER.info("started service for updating item details");
		Optional<MenuItem> item=menuItemDao.findById(menuItem.getId());
		if(item.isPresent()) {
			LOGGER.debug("Item with id"+menuItem.getId()+" is present");
			MenuItem mi=item.get();
			mi.setName(menuItem.getName());
			mi.setPrice(menuItem.getPrice());
			mi.setActive(menuItem.getActive());
			mi.setCategory(menuItem.getCategory());
			mi.setDateOfLaunch(menuItem.getDateOfLaunch());
			mi.setFreeDelivery(menuItem.getFreeDelivery());
			mi.setId(menuItem.getId());
			menuItemDao.save(menuItem);
		}
		else {
			throw new MenuItemNotFound("Item not present");
		}
		return "Item successfully updated";
		
	}
	
	

}
