package com.example.efootstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.efootstore.dao.ShareDao;
import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.Share;

@Service
@Transactional
public class ShareServiceImpl implements ShareService{

	@Autowired
	private ShareDao shareDao;
	
	@Override
	public Share getShare(String shId) {
		return shareDao.getShare(shId);
	}

	@Override
	public List<Share> getShareList() {
		return shareDao.getShareList();
	}

	@Override
	public void insertShare(Share sh) {
		shareDao.insertShare(sh);				
	}

	@Override
	public void deleteShare(String shId) {
		shareDao.deleteShare(shId);
	}

	@Override
	public void updateShare(Share sh) {
		shareDao.updateShare(sh);
	}


	@Override
	public List<Share> getShareListByHeader(String userId) {
		return shareDao.getShareListByHeader(userId);
	}

	@Override
	public List<Share> getMyShare(String userId) {
		return shareDao.getMyShare(userId);
	}
	

	@Override
	public void applyShare(String shId, String userId) {
		shareDao.applyShare(shId, userId);
	}

	@Override
	public void cancelApplyShare(String shId, String userId) {
		shareDao.cancelApplyShare(shId, userId);		
	}

	@Override
	public List<Account> getApplyerOfShare(String shId) {
		return shareDao.getApplyerOfShare(shId);
	}



}
