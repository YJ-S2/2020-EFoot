package com.example.efootstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.efootstore.dao.OrderDao;
import com.example.efootstore.domain.Item;
import com.example.efootstore.domain.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Order getOrder(String orderId) {
		return orderDao.getOrder(orderId);
	}
	@Override
	public List<Order> getOrdersByUsername(String username) {
		return orderDao.getOrdersByUsername(username);
	}

	@Override
	public void insertOrder(Order order) {
		orderDao.insertOrder(order);
		
	}
	@Override
	public List<Order> getOrderList() {
		return orderDao.getOrderList();
	}
	@Override
	public List<Item> getList(String saleId) {
		return orderDao.getList(saleId);
	}

}
