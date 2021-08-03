package com.example.efootstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.efootstore.domain.Sales;
import com.example.efootstore.service.SalesService;

@Controller
@SessionAttributes({"salesDetail","MySales"})
public class ViewSalesDetailController {
	private SalesService saleSev;

	@Autowired
	public void setPetStore(SalesService saleSev) {
		this.saleSev = saleSev;
	}

	@RequestMapping("/shop/viewSalesDetail.do")
	public String handleRequest(@RequestParam("salesId") String salesId, ModelMap model) throws Exception {
		Sales sales = this.saleSev.getSales(salesId);
		model.put("salesDetail", sales);
		return "SalesDetail";
	}
	
	@RequestMapping("/shop/mySales.do")
	public String handleRequest2(@RequestParam("userId") String userId, ModelMap model) {
		List<Sales> salesList = this.saleSev.getSalesListByUserId(userId);
		
		model.put("MySales", salesList);
		
		return "MySales";
	}
}
