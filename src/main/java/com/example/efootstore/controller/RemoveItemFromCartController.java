package com.example.efootstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.efootstore.domain.CartMap;

@Controller
@SessionAttributes("sessionCartMap")
public class RemoveItemFromCartController { 

	@RequestMapping("/shop/removeItemFromCart.do")
	public ModelAndView handleRequest(
			@RequestParam("workingItemId") String workingItemId,
			@ModelAttribute("sessionCartMap") CartMap map) throws Exception{
		map.getCartMap().remove(workingItemId);
		return new ModelAndView("Cart", "map", map);
	}
}
