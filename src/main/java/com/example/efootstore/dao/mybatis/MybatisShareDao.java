package com.example.efootstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.efootstore.dao.ShareDao;
import com.example.efootstore.dao.mybatis.mapper.ShareMapper;
import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.Item;
import com.example.efootstore.domain.Share;

@Repository
public class MybatisShareDao implements ShareDao{
	@Autowired
	private ShareMapper shareMapper;
	
	@Override
	public Share getShare(String shId) {
		Share share = shareMapper.getShare(shId);
		System.out.println(shareMapper.getApplyerOfShare(shId).size());
		share.setShareApplyer(shareMapper.getApplyerOfShare(shId));
		return shareMapper.getShare(shId);		
	}

	@Override
	public Item getShareItem(String shId) {
		return null;
	}

	@Override
	@Transactional
	public void insertShare(Share sh) {
		shareMapper.insertShare(sh);
		shareMapper.insertShareItem(sh);
	}

	@Override
	@Transactional
	public void updateShare(Share sh) {
		shareMapper.updateShare(sh);			
		shareMapper.updateShareItem(sh);
	}


	@Override
	@Transactional
	public void deleteShare(String shId) {
		shareMapper.deleteShareItem(shId); 
//		shareMapper.deleteShareApplyer(shId);
		shareMapper.deleteShare(shId);
	}


	@Override
	public void applyShare(String shId, String userId) {
		shareMapper.applyShare(shId, userId);
	}

	@Override
	public void cancelApplyShare(String shId, String userId) {
		shareMapper.cancelApplyShare(shId, userId);
	}
	
/******************************************************************/
	
	@Override
	public List<Share> getShareList() {
		return shareMapper.getShareList();
	}
	
	public List<Account> getApplyerOfShare(String shId) {
		List<Account> rslt = shareMapper.getApplyerOfShare(shId);
		
		return rslt;
	}
	
	@Override
	public List<Share> getShareListByHeader(String userId) {
		List<Share> rslt = shareMapper.getShareListByHeader(userId);
		for(Share sh : rslt) {			
			List<Account> shareApplyer = shareMapper.getApplyerOfShare(sh.getShId());
			Item shitem = shareMapper.getShareItem(sh.getShId());
			
			sh.setShareApplyer(shareApplyer);
			sh.setItem(shitem);
		}
		return rslt;
	}

	@Override
	public List<Share> getMyShare(String userId) {
		List<Share> rslt = shareMapper.getMyShare(userId);
		
		  for(Share sh : rslt) {
			  List<Account> shApplyer = shareMapper.getApplyerOfShare(sh.getShId()); 
			  Item shitem = shareMapper.getShareItem(sh.getShId()); 
			  sh.setShareApplyer(shApplyer);
			  sh.setItem(shitem); }
		 
		return rslt;
	}

}
