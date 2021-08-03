package com.example.efootstore.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.Auction;
import com.example.efootstore.domain.Item;

public interface AuctionMapper {
	Auction getAuction(String aucId) throws DataAccessException; /* ��� ǰ�� ������ */

	List<Auction> getAuctionList() throws DataAccessException; /* ���ǰ���� ��� */

	List<Auction> getAuctionListByHeader(String userId) throws DataAccessException; /* ����ڰ� ��������ϴ� ǰ�� ��� */

	List<Account> getApplyerOfAuction(String aucId) throws DataAccessException; /* ��� ǰ���� ��û�� ��� */

	List<Auction> getMyAuction(String userId) throws DataAccessException; /* ����ڰ� ��û�� ��� ��� */

	Item getAuctionItem(String aucId) throws DataAccessException; /* ����� ������ */

	
	
	
	void insertAuction(Auction auc) throws DataAccessException;

	void insertAuctionItem(Auction auc) throws DataAccessException;

	void updateAuction(Auction auc) throws DataAccessException;

	void updateAuctionItem(Auction auc) throws DataAccessException;

	void deleteAuction(String aucId) throws DataAccessException;

	void deleteAuctionItem(String aucId) throws DataAccessException;

	void deleteAuctionApplyer(String aucId) throws DataAccessException;

	void applyAuction(Auction auc) throws DataAccessException;

	void cancelApplyAuction(@Param("aucId")String aucId,@Param("userId")String userId)  throws DataAccessException;
}
