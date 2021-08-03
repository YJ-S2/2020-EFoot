package com.example.efootstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.efootstore.dao.CategoryDao;
import com.example.efootstore.dao.SalesDao;
import com.example.efootstore.domain.Category;
import com.example.efootstore.domain.Sales;


@Service
@Transactional
public class SalesServiceImpl implements SalesService {
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private SalesDao salesDao;

	public List<Sales> getSalesListByCategory(String categoryId) {
		return salesDao.getSalesListByCategory(categoryId);
	}


	public Category getCategory(String categoryId) {
		return categoryDao.getCategory(categoryId);
	}


	@Override
	public Sales getSales(String salesId) {
		return salesDao.getSales(salesId);
	}


	@Override
	public void updateSales(Sales sales) {
		salesDao.updateSales(sales);
	}


	@Override
	public List<Sales> getSalesListByUserId(String userId) {
		return salesDao.getSalesListByUserId(userId);
	}


	@Override
	public void insertSales(Sales sales) {
		salesDao.insertSales(sales);
	}


	@Override
	public void deleteSales(String saleId) {
		salesDao.deleteSales(saleId);
	}

}
