package com.example.efootstore.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.efootstore.dao.AccountDao;
import com.example.efootstore.dao.CategoryDao;
import com.example.efootstore.dao.ItemDao;
import com.example.efootstore.dao.OrderDao;
import com.example.efootstore.dao.ProductDao;
import com.example.efootstore.dao.SalesDao;
import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.Category;
import com.example.efootstore.domain.Item;
import com.example.efootstore.domain.Order;
import com.example.efootstore.domain.Product;
import com.example.efootstore.domain.Sales;

@Service
@Transactional
public class PetStoreImpl implements PetStoreFacade { 
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private SalesDao salesDao;



	//-------------------------------------------------------------------------
	// Operation methods, implementing the PetStoreFacade interface
	//-------------------------------------------------------------------------

	public Account getAccount(String userId) {
		return accountDao.getAccount(userId);
	}

	public Account getAccount(String userId, String password) {
		return accountDao.getAccount(userId, password);
	}

	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}

	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	public List<String> getUsernameList() {
		return accountDao.getUsernameList();
	}

	public Category getCategory(String categoryId) {
		return categoryDao.getCategory(categoryId);
	}

	public List<Product> getProductListByCategory(String categoryId) {
		return productDao.getProductListByCategory(categoryId);
	}

	public List<Product> searchProductList(String keywords) {
		return productDao.searchProductList(keywords);
	}

	public Product getProduct(String productId) {
		return productDao.getProduct(productId);
	}


	public Item getItem(String itemId) {
		return itemDao.getItem(itemId);
	}
	
	

	public List<Order> getOrdersByUsername(String username) {
		return orderDao.getOrdersByUsername(username);
	}

	public List<Sales> getSalesListByCategory(String categoryId) {
		return salesDao.getSalesListByCategory(categoryId);
	}

	public Sales getSales(String salesId) {
		return salesDao.getSales(salesId);
	}

	@Override
	public List<Item> searchItemList(String name) {
		return itemDao.searchItemList(name);
	}



}