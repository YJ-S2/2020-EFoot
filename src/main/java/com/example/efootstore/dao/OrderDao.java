package com.example.efootstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.efootstore.domain.Item;
import com.example.efootstore.domain.Order;

public interface OrderDao {


  List<Order> getOrdersByUsername(String username) throws DataAccessException;
  Order getOrder(String orderId) throws DataAccessException;
  void insertOrder(Order order) throws DataAccessException;
  List<Order> getOrderList() throws DataAccessException;
  List<Item> getList(String saleId)throws DataAccessException;
}
