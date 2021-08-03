package com.example.efootstore.dao.mybatis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.efootstore.dao.CategoryDao;
import com.example.efootstore.dao.mybatis.mapper.CategoryMapper;
import com.example.efootstore.domain.Category;

@Repository
public class MybatisCategoryDao implements CategoryDao {
	@Autowired
	private CategoryMapper categoryMapper;

	public Category getCategory(String categoryId) throws DataAccessException {
		return categoryMapper.getCategory(categoryId);
	}


}
