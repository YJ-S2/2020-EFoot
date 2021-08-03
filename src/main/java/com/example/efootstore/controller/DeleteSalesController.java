package com.example.efootstore.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.efootstore.domain.Category;
import com.example.efootstore.domain.Sales;
import com.example.efootstore.service.SalesService;

@Controller
public class DeleteSalesController {
	
	@Autowired
	private SalesService service;
	public void setReview(SalesService service) {
		this.service = service;
	}
	
	@RequestMapping("/shop/deleteSales.do")
	public String handleRequest(@RequestParam("saleId") String saleId,
			@RequestParam("categoryId") String categoryId, ModelMap model) {
		service.deleteSales(saleId);
	
		Category category = this.service.getCategory(categoryId);
		
		
		List<Sales> salesListdata = this.service.getSalesListByCategory(categoryId);
		
		model.put("category", category);
		model.put("salesListdata", salesListdata);
	
		return "Sales";
	}
}
