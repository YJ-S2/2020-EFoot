package com.example.efootstore.dao;

import java.util.List;

import com.example.efootstore.domain.Sales;

public interface SalesDao {
	
	List<Sales> getSalesListByCategory(String categoryId);
	Sales getSales(String salesId);
	
	List<Sales> getSalesListByUserId(String userId);

	void insertSales(Sales sales);
	void deleteSales(String saleId);
	void updateSales(Sales sales);

}
