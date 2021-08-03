package com.example.efootstore.service;

import java.util.List;

import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.Share;

public interface ShareService {
	Share getShare(String shId);
	List<Share> getShareList();
	
	List<Account> getApplyerOfShare(String shId);
	List<Share> getShareListByHeader(String userId); 
	List<Share> getMyShare(String userId);  
	
	void applyShare(String shId, String userId); 
	void cancelApplyShare(String shId, String userId);
	
	void insertShare(Share sh);
	void deleteShare(String shId);
	void updateShare(Share sh);
}
