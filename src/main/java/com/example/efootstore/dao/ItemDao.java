package com.example.efootstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.efootstore.domain.Item;

public interface ItemDao {

  Item getItem(String itemId) throws DataAccessException;
  List<Item> searchItemList(String keywords) throws DataAccessException;
  
}
