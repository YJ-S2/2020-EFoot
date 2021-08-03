package com.example.efootstore.controller.rest;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.efootstore.domain.Sales;
import com.example.efootstore.service.SalesService;

@Controller
public class RestfulSalesController {
	private SalesService saleSev;
	
	@Autowired
	public void setSales(SalesService saleSev) {
		this.saleSev = saleSev;
	}
	
	@RequestMapping(value = "/sales/{userId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Sales> getSalesListByUserId(@PathVariable("userId") String userId, HttpServletResponse response)
		throws Exception {
		List<Sales> salesDetail = saleSev.getSalesListByUserId(userId);
		if (salesDetail == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return salesDetail; 
	}
	
	
}
