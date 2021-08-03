package com.example.efootstore.service;

import java.util.List;

import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.Auction;
import com.example.efootstore.domain.PointHistory;



public interface AuctionService {
	List<Auction> getAuctionList();
	Auction getAuction(String aucId); 
	List<Auction> getAuctionListByHeader(String userId);
	List<Auction> getMyAuction(String userId);
	List<Account> getApplyerOfAuction(String aucId); 
	void cancelApplyAuction(String aucId, String userId);
	void insertAuction(Auction auction, PointHistory ph);
	void updateAuction(Auction auction);
	void deleteAuction(String aucId);
	void applyAuction(Auction auction);
	
}
