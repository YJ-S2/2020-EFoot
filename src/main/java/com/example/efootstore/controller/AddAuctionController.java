package com.example.efootstore.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.efootstore.domain.Auction;
import com.example.efootstore.domain.PointHistory;
import com.example.efootstore.service.AuctionFormValidator;
import com.example.efootstore.service.AuctionService;

@Controller
@RequestMapping("/shop/addAuction.do")
public class AddAuctionController {

	@Value("AddAuctionForm")
	private String formViewName;

	@Value("AuctionList")
	private String successViewName;

	private AuctionService auctionService;

	@Autowired
	public void setAuction(AuctionService auctionService) {
		this.auctionService = auctionService;
	}

	@ModelAttribute("Auction")
	public Auction formBackingObject(HttpServletRequest request) throws Exception {
		return new Auction();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleRequest(@Valid @ModelAttribute("Auction") Auction auction, BindingResult result, ModelMap model) {
		
		new AuctionFormValidator().validate(auction, result);
		if (result.hasErrors())
	         return formViewName;
		
		PointHistory ph = new PointHistory();
		Date date = new Date();

		ph.setHistory("경매 추가 ! 포인트 적립 !");
		ph.setAmount(50);
		ph.setStatus(1);
		ph.setDate(date);
		ph.setUserId(auction.getUserId());
		
		
		auctionService.insertAuction(auction, ph);
		List<Auction> list = this.auctionService.getAuctionList();
		

		model.put("auctionList", list);
		return successViewName;
	}
}
