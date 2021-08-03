package com.example.efootstore.dao.mybatis.mapper;

import java.util.List;

import com.example.efootstore.domain.Item;
import com.example.efootstore.domain.Sales;

public interface SalesMapper {
	
	List<Sales> getSalesListByCategory(String categoryId);
	Sales getSales(String salesId);
	Item getSalesItem(String salesId);
	List<Sales> getSalesListByUserId(String userId);

	void insertSales(Sales sales);
	void insertSalesItem(Item item);
	
	void deleteSales(String saleId);
	void deleteSalesItem(String saleId);
	
	void updateSales(Sales sales);
	void updateSaleItem(Item item);
	
}
