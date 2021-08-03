package com.example.efootstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.efootstore.domain.Auction;
import com.example.efootstore.service.AuctionService;


@Controller
public class DeleteAuctionController {
	
	
	private AuctionService auctionService;
	
	@Autowired
	public void setAuction(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	
	@RequestMapping("/shop/deleteAuction.do")
	public String handleRequest(@RequestParam("aucId") String aucId, ModelMap model) {
		auctionService.deleteAuction(aucId);
		List<Auction> list = this.auctionService.getAuctionList();

		model.put("auctionList", list);

		return "AuctionList";
	}
}
