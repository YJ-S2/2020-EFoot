package com.example.efootstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.efootstore.domain.Cart;
import com.example.efootstore.domain.CartMap;
import com.example.efootstore.domain.Sales;
import com.example.efootstore.service.SalesService;

@Controller
@SessionAttributes("sessionCartMap")
public class AddItemToCartController { 
	@Autowired
	private SalesService salesService;

	
	@ModelAttribute("sessionCartMap")
	public CartMap cartMap() {
		return new CartMap();
	}
	
	@RequestMapping("/shop/addItemToCart.do")
	public ModelAndView AddCartSubmit(@RequestParam("workingItemId") String workingItemId,
								@ModelAttribute("sessionCartMap") CartMap map) throws Exception {
		Sales item = salesService.getSales(workingItemId);
		Cart cart = new Cart();
		cart.setSaleId(item.getSaleId());
		cart.setCateId(item.getCateId());
		cart.setUserId(item.getUserId());
		cart.setItemName(item.getItemName());
		cart.setPrice(item.getItem().getPrice());
		map.getCartMap().put(cart.getSaleId(), cart);
		return new ModelAndView("Cart", "map", map);
	}
}