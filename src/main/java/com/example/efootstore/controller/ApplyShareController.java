package com.example.efootstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.efootstore.service.ShareService;

@Controller
public class ApplyShareController {
	private ShareService shareService;
	
	@Autowired
	public void setShare(ShareService shareService) {
		this.shareService = shareService;
	}
	
	@RequestMapping("/shop/applyShare.do")
	public String applyShare(RedirectAttributes redirect, 
									@RequestParam("shId") String shId,
									@RequestParam("userId") String userId) {
		shareService.applyShare(shId, userId);
		redirect.addAttribute("shId", shId);
		 return "redirect:/shop/shareDetail.do";
	}
	
	@RequestMapping("/shop/cancelShare.do")
	public String cancelShare(@RequestParam("shId") String shId,
								@RequestParam("userId") String userId,
								RedirectAttributes redirect) {
		shareService.cancelApplyShare(shId, userId);
		redirect.addAttribute("shId", shId);
		
		return "redirect:/shop/shareDetail.do";
	}
}