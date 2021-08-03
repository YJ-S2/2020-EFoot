package com.example.efootstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.efootstore.dao.GroupBuyingDao;
import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.GroupBuying;


@Service
public class GroupBuyingServiceImpl implements GroupBuyingService{
	@Autowired
	private GroupBuyingDao gbDao;

	@Override
	public GroupBuying getGroupBuying(String gbId) {
		return gbDao.getGroupBuying(gbId); 
	}

	@Override
	public List<GroupBuying> getGroupBuyingList() {
		return gbDao.getGroupBuyingList();
	}

	@Override
	public List<GroupBuying> getGroupBuyingListByHeader(String userId) {
		return gbDao.getGroupBuyingListByHeader(userId);
	}

	@Override
	public List<Account> getApplyerOfGroupBuying(String gbId) {
		return gbDao.getApplyerOfGroupBuying(gbId);
	}

	@Override
	public List<GroupBuying> getMyGroupBuying(String userId) {
		return gbDao.getMyGroupBuying(userId);
	}

	@Override
	public void insertGroupBuying(GroupBuying gb) {
		gbDao.insertGroupBuying(gb);
	}

	@Override
	public void updateGroupBuying(GroupBuying gb) {
		gbDao.updateGroupBuying(gb);
		
	}

	@Override
	public void deleteGroupBuying(String gbId) {
		gbDao.deleteGroupBuying(gbId);
	}

	@Override
	public void applyGroupBuying(String gbId, String userId) {	
		gbDao.applyGroupBuying(gbId, userId);
	}

	@Override
	public void cancelApplyGroupBuying(String gbId, String userId) {
		gbDao.cancelApplyGroupBuying(gbId, userId);
	}

}
