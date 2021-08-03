package com.example.efootstore.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.efootstore.domain.Auction;
import com.example.efootstore.service.AuctionService;

@Controller
public class ViewAuctionDetailController {
	private AuctionService auctionService;
	

	@Autowired
	public void setAuction(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	
  
   @RequestMapping("/shop/viewAuctionDetail.do")
   public String handleRequest(@RequestParam("aucId") String aucId, ModelMap model) throws Exception {
      Auction auction = this.auctionService.getAuction(aucId);
      model.put("auctionDetail", auction);
      model.put("applyAuction", auctionService.getApplyerOfAuction(aucId));
      return "AuctionDetail";
   
   }

	
}