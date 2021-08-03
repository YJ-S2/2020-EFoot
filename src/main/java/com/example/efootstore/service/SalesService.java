package com.example.efootstore.service;

import java.util.List;

import com.example.efootstore.domain.Category;
import com.example.efootstore.domain.Sales;

public interface SalesService {
	Category getCategory(String categoryId);
	Sales getSales(String salesId);
	List<Sales> getSalesListByCategory(String categoryId);
	void updateSales(Sales sales);
	List<Sales> getSalesListByUserId(String userId);
	void insertSales(Sales sales);
	void deleteSales(String saleId);
}
