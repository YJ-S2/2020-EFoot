package com.example.efootstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.efootstore.service.GroupBuyingService;

@Controller
public class ApplyGroupBuying {
	@Autowired
	private GroupBuyingService gbService;
	
	@RequestMapping("/shop/applyGB.do")
	public String applyGroupBuying(RedirectAttributes redirect, 
									@RequestParam("gbId") String gbId,
									@RequestParam("userId") String userId) {
		gbService.applyGroupBuying(gbId, userId);
		redirect.addAttribute("gbId", gbId); System.out.println(gbId);
		
		return "redirect:/shop/gbDetail.do";
	}
	
	@RequestMapping("/shop/cancelGB.do")
	public String cancelGroupBuying(@RequestParam("gbId") String gbId,
								@RequestParam("userId") String userId,
								RedirectAttributes redirect) {
		gbService.cancelApplyGroupBuying(gbId, userId);
		redirect.addAttribute("gbId", gbId); 
		
		return "redirect:/shop/gbDetail.do";
	}

}
