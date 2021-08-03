package com.example.efootstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.efootstore.dao.AuctionDao;
import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.Auction;
import com.example.efootstore.domain.PointHistory;


@Service
@Transactional
public class AuctionServiceImpl implements AuctionService{
	@Autowired
	private AuctionDao auctionDao;
	
	

	@Override
	public List<Auction> getAuctionList(){
		return auctionDao.getAuctionList();
	}
	@Override
	public Auction getAuction(String aucId) {
		return auctionDao.getAuction(aucId);
	}
	@Override
	public List<Auction> getAuctionListByHeader(String userId) {
		return auctionDao.getAuctionListByHeader(userId);
	}
	@Override
	public List<Auction> getMyAuction(String userId) {
		return auctionDao.getMyAuction(userId);
	}
	@Override
	public List<Account> getApplyerOfAuction(String aucId) {
		return auctionDao.getApplyerOfAuction(aucId);
	}
	@Override
	public void cancelApplyAuction(String aucId, String userId) {
		auctionDao.cancelApplyAuction(aucId, userId);
	}
	@Override
	public void insertAuction(Auction auction, PointHistory ph) {
		auctionDao.insertAuction(auction, ph);
	}

	@Override
	public void updateAuction(Auction auction) {
		auctionDao.updateAuction(auction);
	}

	@Override
	public void deleteAuction(String aucId) {
		auctionDao.deleteAuction(aucId);
	}
	@Override
	public void applyAuction(Auction auction) {
		auctionDao.applyAuction(auction);
	}
}
