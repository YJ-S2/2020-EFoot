package com.example.efootstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.efootstore.dao.AuctionDao;
import com.example.efootstore.dao.mybatis.mapper.AuctionMapper;
import com.example.efootstore.dao.mybatis.mapper.PointHistoryMapper;
import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.Auction;
import com.example.efootstore.domain.Item;
import com.example.efootstore.domain.PointHistory;

@Repository
public class MybatisAuctionDao implements AuctionDao {
	@Autowired
	private AuctionMapper auctionMapper;
	@Autowired
	private PointHistoryMapper pointMapper;

	@Override
	public Auction getAuction(String aucId) {
		 return auctionMapper.getAuction(aucId);
	}

	@Override
	public List<Auction> getAuctionList() {
		return auctionMapper.getAuctionList();
	}

	@Override
	public List<Auction> getAuctionListByHeader(String userId) {
		List<Auction> rslt = auctionMapper.getAuctionListByHeader(userId);
		for (Auction auc : rslt) {
			List<Account> aucApplyer = auctionMapper.getApplyerOfAuction(auc.getAucId());
			Item aucitem = auctionMapper.getAuctionItem(auc.getAucId());

			auc.setAucApplyer(aucApplyer);
			auc.setItem(aucitem);
		}
		return rslt;
	}
	public List<Account> getApplyerOfAuction(String aucId) {
		List<Account> rslt = auctionMapper.getApplyerOfAuction(aucId);
		
		return rslt;
	}
	@Override
	public List<Auction> getMyAuction(String userId) {
	
		return auctionMapper.getMyAuction(userId);
	}

	@Override
	@Transactional
	public void insertAuction(Auction auc, PointHistory ph) {
		auctionMapper.insertAuction(auc);
		auctionMapper.insertAuctionItem(auc);
		pointMapper.insertPointHistory(ph);
		try {
			pointMapper.updatePlusPoint(auc.getUserId(), ph.getAmount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	

	@Override
	public void updateAuction(Auction auc) {
		auctionMapper.updateAuction(auc);
		auctionMapper.updateAuctionItem(auc);
	}

	@Override
	public void deleteAuction(String aucId) {
		auctionMapper.deleteAuctionItem(aucId);
		auctionMapper.deleteAuction(aucId);

	}

	@Override
	public void applyAuction(Auction auction) {
		auctionMapper.applyAuction(auction);
	}

	@Override
	public void cancelApplyAuction(String aucId, String userId) {
		 auctionMapper.cancelApplyAuction(aucId, userId);
	}

}
