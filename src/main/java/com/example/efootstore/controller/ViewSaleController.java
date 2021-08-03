package com.example.efootstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.efootstore.domain.Category;
import com.example.efootstore.domain.Sales;
import com.example.efootstore.service.SalesService;

@Controller
@SessionAttributes({"category", "salesListdata"})
public class ViewSaleController {
	private SalesService saleSev;

	@Autowired
	public void setPetStore(SalesService saleSev) {
		this.saleSev = saleSev;
	}
	
	@RequestMapping("/shop/viewSales.do")
	public String handleRequest(
			@RequestParam("categoryId") String categoryId,
			ModelMap model
			) throws Exception {
		Category category = this.saleSev.getCategory(categoryId);
		
	
		List<Sales> salesListdata = this.saleSev.getSalesListByCategory(categoryId);
		
		model.put("category", category);
		model.put("salesListdata", salesListdata);
	
		return "Sales";
	}
}
