package com.example.efootstore.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.efootstore.domain.Auction;
import com.example.efootstore.service.AuctionService;

@Controller
@RequestMapping("/shop/ApplyAuctionForm.do")
public class ApplyAuctionForm {
	@Value("ApplyAuctionForm")
	private String formViewName;
	
	@Value("AuctionList")
	private String successViewName;
	
	private AuctionService auctionService;
	
	@Autowired
	public void setAuction(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	

	@ModelAttribute("Auction")
	public Auction formBackingObject(HttpServletRequest request) 
			throws Exception {
		return new Auction();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	   public String handleRequest(@RequestParam("aucId") String aucId, ModelMap model) throws Exception {
	      Auction auction = this.auctionService.getAuction(aucId);
	      model.put("auction", auction);
	      return formViewName;
	   
	   }
	
	@RequestMapping(method = RequestMethod.POST)
	public String handleRequest(@ModelAttribute("Auction") Auction auction, ModelMap model) {

		System.out.print(auction.getAucId()+ auction.getUserId()+auction.getPrice());
		auctionService.applyAuction(auction);
		List<Auction> list = this.auctionService.getAuctionList();

	
		model.put("auctionList", list);

		return successViewName;
	}

}
