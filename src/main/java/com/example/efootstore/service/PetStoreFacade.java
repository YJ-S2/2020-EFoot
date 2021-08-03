package com.example.efootstore.service;


import java.util.List;

import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.Category;
import com.example.efootstore.domain.Item;
import com.example.efootstore.domain.Order;
import com.example.efootstore.domain.Product;
import com.example.efootstore.domain.Sales;


public interface PetStoreFacade {

	Account getAccount(String userId);

	Account getAccount(String userId, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);

	List<String> getUsernameList();

	Category getCategory(String categoryId);
	
	List<Sales> getSalesListByCategory(String categoryId);

	List<Product> searchProductList(String keywords);

	Product getProduct(String productId);
	
	Item getItem(String itemId);

	

	List<Order> getOrdersByUsername(String username);

	Sales getSales(String salesId);
	
	List<Item> searchItemList(String name);

}