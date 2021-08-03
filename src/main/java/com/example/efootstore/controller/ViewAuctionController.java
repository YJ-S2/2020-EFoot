package com.example.efootstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.efootstore.domain.Auction;
import com.example.efootstore.service.AuctionService;

@Controller
public class ViewAuctionController {

	private AuctionService auctionService;

	@Autowired
	public void setAuction(AuctionService auctionService) {
		this.auctionService = auctionService;
	}

	@RequestMapping("/shop/viewAuction.do")
	public String handleRequest(ModelMap model) throws Exception {
		List<Auction> auctionList = this.auctionService.getAuctionList();

		model.put("auctionList", auctionList);
		return "AuctionList";
	}

	@RequestMapping("/shop/aucByHeader.do")
	public String viewAuctionListByHeader(@RequestParam("userId") String userId, ModelMap model) {
		model.put("auctionListByHeader", this.auctionService.getAuctionListByHeader(userId));
		return "AuctionListByHeader";
	}

	@RequestMapping("/shop/myAuction.do")
	public String viewMyAuctionList(@RequestParam("userId") String userId, ModelMap model) {
		model.put("MyAuctionList", auctionService.getMyAuction(userId));
		return "MyAuctionList";
	}

	@RequestMapping("/shop/cancelAuction.do")
	public String cancelAuction(@RequestParam("aucId") String aucId, @RequestParam("userId") String userId, RedirectAttributes redirect) {
		auctionService.cancelApplyAuction(aucId, userId);
        redirect.addAttribute("userId", userId);	
		return "redirect:/shop/myAuction.do";
	}
	
}