package com.example.efootstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.efootstore.dao.GroupBuyingDao;
import com.example.efootstore.dao.mybatis.mapper.GroupBuyingMapper;
import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.GroupBuying;
import com.example.efootstore.domain.Item;

@Repository
public class MybatisGroupByuyingDao implements GroupBuyingDao{
	@Autowired
	private GroupBuyingMapper groupbuyingMapper;

	@Override
	public GroupBuying getGroupBuying(String gbId) {
		GroupBuying rslt = groupbuyingMapper.getGroupBuying(gbId);		
		List<Account> gbApplyer = groupbuyingMapper.getApplyerOfGroupBuying(gbId);
		Item gbitem = groupbuyingMapper.getGroupBuyingItem(gbId);
		
		rslt.setGbApplyer(gbApplyer);
		rslt.setItem(gbitem);
		
		return rslt;
	}

	@Override
	public List<GroupBuying> getGroupBuyingList() {
		List<GroupBuying> rslt = groupbuyingMapper.getGroupBuyingList();
		for(GroupBuying gb : rslt) {			
			List<Account> gbApplyer = groupbuyingMapper.getApplyerOfGroupBuying(gb.getGbId());
			Item gbitem = groupbuyingMapper.getGroupBuyingItem(gb.getGbId());
			
			gb.setGbApplyer(gbApplyer);
			gb.setItem(gbitem);
		}
		return rslt;
	}

	public List<Account> getApplyerOfGroupBuying(String gbId) {
		List<Account> rslt = groupbuyingMapper.getApplyerOfGroupBuying(gbId);
		
		return rslt;
	}


	@Override
	public List<GroupBuying> getGroupBuyingListByHeader(String userId) {
		List<GroupBuying> rslt = groupbuyingMapper.getGroupBuyingListByHeader(userId);
		for(GroupBuying gb : rslt) {			
			List<Account> gbApplyer = groupbuyingMapper.getApplyerOfGroupBuying(gb.getGbId());
			Item gbitem = groupbuyingMapper.getGroupBuyingItem(gb.getGbId());
			
			gb.setGbApplyer(gbApplyer);
			gb.setItem(gbitem);
		}
		return rslt;
	}
	@Override
	public List<GroupBuying> getMyGroupBuying(String userId) {
		List<GroupBuying> rslt = groupbuyingMapper.getMyGroupBuying(userId);
		for(GroupBuying gb : rslt) {			
			List<Account> gbApplyer = groupbuyingMapper.getApplyerOfGroupBuying(gb.getGbId());
			Item gbitem = groupbuyingMapper.getGroupBuyingItem(gb.getGbId());
			
			gb.setGbApplyer(gbApplyer);
			gb.setItem(gbitem);
		}
		return rslt;
	}

	@Override
	@Transactional
	public void insertGroupBuying(GroupBuying gb) {
		groupbuyingMapper.insertGroupBuying(gb);
	    gb.getItem().setGbId(gb.getGbId());
		groupbuyingMapper.insertGroupBuyingItem(gb.getItem());
	}

	@Override
	@Transactional
	public void updateGroupBuying(GroupBuying gb) {
		groupbuyingMapper.updateGroupBuying(gb);
		gb.getItem().setGbId(gb.getGbId());
		groupbuyingMapper.updateGroupBuyingItem(gb.getItem());
	}

	@Override
	@Transactional
	public void deleteGroupBuying(String gbId) {
		groupbuyingMapper.deleteGroupBuyingItem(gbId);
		groupbuyingMapper.deleteGroupBuyingApplyer(gbId);
		groupbuyingMapper.deleteGroupBuying(gbId);
		
	}

	@Override
	public void applyGroupBuying(String gbId, String userId) {
		groupbuyingMapper.applyGroupBuying(gbId, userId);
	}

	@Override
	public void cancelApplyGroupBuying(String gbId, String userId) {
		groupbuyingMapper.cancelApplyGroupBuying(gbId, userId);
	}

}
