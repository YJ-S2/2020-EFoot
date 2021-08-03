package com.example.efootstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.efootstore.domain.Product;

public interface ProductDao {

	List<Product> getProductListByCategory(String categoryId) throws DataAccessException;

	List<Product> searchProductList(String keywords) throws DataAccessException;

	Product getProduct(String productId) throws DataAccessException;

}
