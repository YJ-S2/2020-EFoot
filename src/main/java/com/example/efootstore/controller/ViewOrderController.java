package com.example.efootstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.efootstore.domain.Order;
import com.example.efootstore.service.OrderService;

@Controller
public class ViewOrderController {
	
	private OrderService orderService;
		

		@Autowired
		public void setOrder(OrderService orderService) {
			this.orderService = orderService;
		}
	
		 
		 @RequestMapping("/shop/orderList.do")
		   public String handleRequest1(@RequestParam("userId") String userId, ModelMap model) throws Exception {	      
		      model.put("orderList", orderService.getOrdersByUsername(userId));
		      return "MyOrderList";
		   
		   }
	   @RequestMapping("/shop/viewOrder.do")
	   public String handleRequest(@RequestParam("orderId") String orderId, ModelMap model) throws Exception {
	      Order order = this.orderService.getOrder(orderId);
	      model.put("orderDetail", order);
	      return "OrderDetail";
	   
	   }
}
