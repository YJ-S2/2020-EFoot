package com.example.efootstore.service;

import java.util.List;

import com.example.efootstore.domain.Item;
import com.example.efootstore.domain.Order;

public interface OrderService {
	  
	
	List<Order> getOrdersByUsername(String username);
	Order getOrder(String orderId);
	void insertOrder(Order order);
	List<Order> getOrderList();
	List<Item> getList(String saleId);

}
