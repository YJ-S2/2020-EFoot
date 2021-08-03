package com.example.efootstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.Item;
import com.example.efootstore.domain.Share;

public interface ShareDao {

	Share getShare(String shId); 
	
	List<Share> getShareList(); 
	List<Share> getShareListByHeader(String userId); 
	List<Share> getMyShare(String userId);  
	List<Account> getApplyerOfShare(String shId);

	Item getShareItem(String userId); 

	void insertShare(Share sh) throws DataAccessException;
	void updateShare(Share sh) throws DataAccessException;	
	void deleteShare(String ShId) throws DataAccessException;
	
	void applyShare(String shId, String userId); 
	void cancelApplyShare(String shId, String userId); 
}
