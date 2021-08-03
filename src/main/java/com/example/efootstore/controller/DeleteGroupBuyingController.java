package com.example.efootstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.efootstore.service.GroupBuyingService;

@Controller
public class DeleteGroupBuyingController {
	
	@Autowired
	private GroupBuyingService gbService;

	@RequestMapping("/shop/deleteGB.do")
	public String deleteGroupBuying(@RequestParam("gbId") String gbId) {
		gbService.deleteGroupBuying(gbId);
		 
		 return "redirect:/shop/gblist.do";
	}
	
}
