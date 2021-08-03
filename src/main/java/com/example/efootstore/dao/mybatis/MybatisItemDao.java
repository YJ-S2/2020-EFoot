package com.example.efootstore.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.efootstore.dao.ItemDao;
import com.example.efootstore.dao.mybatis.mapper.ItemMapper;
import com.example.efootstore.domain.Item;

@Repository
public class MybatisItemDao implements ItemDao {
	@Autowired
	private ItemMapper itemMapper;
	
	public Item getItem(String itemId) throws DataAccessException {
		return itemMapper.getItem(itemId);
	}
	
	public List<Item> searchItemList(String keywords) 
			throws DataAccessException {
	    return itemMapper.searchItemList(
	    	"%" + keywords + "%");
	}

}