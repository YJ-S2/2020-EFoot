package com.example.efootstore.dao;

import org.springframework.dao.DataAccessException;

import com.example.efootstore.domain.Category;

public interface CategoryDao {
	
	Category getCategory(String categoryId) throws DataAccessException;
}
