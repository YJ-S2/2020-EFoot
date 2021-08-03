package com.example.efootstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.efootstore.dao.SalesDao;
import com.example.efootstore.dao.mybatis.mapper.SalesMapper;
import com.example.efootstore.domain.Sales;

@Repository
public class MybatisSalesDao implements SalesDao {

	@Autowired
	private SalesMapper salesMapper;
	@Override
	public List<Sales> getSalesListByCategory(String categoryId) {
		List<Sales> rslt = salesMapper.getSalesListByCategory(categoryId);
		return rslt;
	}

	@Override
	public Sales getSales(String salesId) {
		Sales rslt = salesMapper.getSales(salesId);
		return rslt;
	}

	@Override
	@Transactional
	public void insertSales(Sales sales) {
		salesMapper.insertSales(sales);
		sales.getItem().setSaleId(sales.getSaleId());
		sales.getItem().setName(sales.getItemName());
		salesMapper.insertSalesItem(sales.getItem());
	}
	
	@Override
	@Transactional
	public void deleteSales(String saleId) throws DataAccessException {
		salesMapper.deleteSalesItem(saleId);
		salesMapper.deleteSales(saleId);
	}

	@Override
	@Transactional
	public void updateSales(Sales sales) {
		salesMapper.updateSales(sales);
		sales.getItem().setSaleId(sales.getSaleId());
		sales.getItem().setName(sales.getItemName());
		salesMapper.updateSaleItem(sales.getItem());
	}

	@Override
	public List<Sales> getSalesListByUserId(String userId) {
		return salesMapper.getSalesListByUserId(userId);
	}



}
