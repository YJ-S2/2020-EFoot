package com.example.efootstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.efootstore.domain.Auction;
import com.example.efootstore.service.AuctionFormValidator;
import com.example.efootstore.service.AuctionService;

@Controller
@RequestMapping("/shop/updateAuction.do")
public class UpdateAuctionController {
      
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
      public Auction formBackingObject(@RequestParam("aucId") String aucId) throws Exception {
         Auction auction = auctionService.getAuction(aucId);

         return auction;
      }

      @RequestMapping(method = RequestMethod.GET)
      public String showReview() {
         return formViewName;
      }
      
         
      @RequestMapping(method = RequestMethod.POST)
      public String onSubmit(@Valid @ModelAttribute("Auction") Auction auction, BindingResult result, HttpServletRequest request, HttpSession session,  ModelMap model)
            throws Exception {
         
         new AuctionFormValidator().validate(auction, result);
         if (result.hasErrors())         
               return formViewName;
         
         auctionService.updateAuction(auction);
         
         List<Auction> list = this.auctionService.getAuctionList();
         model.put("auctionList", list);
         return successViewName;
      }
   
}