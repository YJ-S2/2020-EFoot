package com.example.efootstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.efootstore.domain.Order;
import com.example.efootstore.service.OrderService;
import com.example.efootstore.service.OrderValidator;

@Controller
@RequestMapping("/shop/orderForm.do")
public class OrderController {
   @Value("OrderForm")
   private String formViewName;

   @Value("ConfirmOrder")
   private String successViewName;

   private OrderService orderService;

   @Autowired
   public void setOrder(OrderService orderService) {
      this.orderService = orderService;
   }

   @ModelAttribute("Order")
   public Order formBackingObject(HttpServletRequest request) throws Exception {
      return new Order();
   }

   @RequestMapping(method = RequestMethod.GET)
   public String showForm(@RequestParam("saleId") String saleId, ModelMap model) {

      model.put("orderSale", orderService.getList(saleId));

      return formViewName;
   }

   @RequestMapping(method = RequestMethod.POST)
   public String handleRequest(@Valid @ModelAttribute("Order") Order order, BindingResult result,
         @RequestParam("saleId") String saleId, ModelMap model) {
      
      new OrderValidator().validate(order, result);

      if (result.hasErrors()) {
         return formViewName;
      }else {

      this.orderService.insertOrder(order);
      order = this.orderService.getOrder(order.getOrderId());

      model.put("orderForm", order);
      return successViewName;
      }
   }

}