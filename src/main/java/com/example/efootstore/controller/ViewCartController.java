package com.example.efootstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.efootstore.domain.CartMap;

@Controller
@SessionAttributes("sessionCartMap")
public class ViewCartController { 

	@ModelAttribute("sessionCartMap")
	public CartMap cartMap() {
		return new CartMap();
	}
	
	@RequestMapping("/shop/viewCart.do")
	public ModelAndView viewCart(@ModelAttribute("sessionCartMap") CartMap map) throws Exception {
		return new ModelAndView("Cart", "map", map);
	}
//
//	@RequestMapping("/shop/checkout.do")
//	public ModelAndView checkout(
//			HttpServletRequest request,
//			@RequestParam(value="page", required=false) String page,
//			@ModelAttribute("sessionCart") Cart cart) 
//			throws Exception {
//		UserSession userSession = 
//			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
//		handleRequest(page, cart, userSession);
//		return new ModelAndView("Checkout", "cart", cart);
//	}
	
}
