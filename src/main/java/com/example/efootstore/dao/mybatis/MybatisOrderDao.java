package com.example.efootstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.efootstore.dao.OrderDao;
import com.example.efootstore.dao.mybatis.mapper.OrderMapper;
import com.example.efootstore.dao.mybatis.mapper.SalesMapper;
import com.example.efootstore.domain.Item;
import com.example.efootstore.domain.Order;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisOrderDao implements OrderDao {
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private SalesMapper salesMapper;
	 public List<Order> getOrdersByUsername(String userId){
		 return orderMapper.getOrdersByUsername(userId);
	 }
	 public Order getOrder(String orderId) {
	
		 return orderMapper.getOrder(orderId);
	  }
	 public void insertOrder(Order order) {
		 orderMapper.insertOrder(order);	
			salesMapper.deleteSalesItem(order.getSaleId());
			salesMapper.deleteSales(order.getSaleId());
	  }
	 public List<Order> getOrderList(){
		 return orderMapper.getOrderList();
	 }
	@Override
	public List<Item> getList(String saleId) throws DataAccessException {
        	return orderMapper.getList(saleId);
	}
}