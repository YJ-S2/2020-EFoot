
package com.example.efootstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.Auction;
import com.example.efootstore.domain.PointHistory;

public interface AuctionDao {

	Auction getAuction(String aucId) throws DataAccessException; /* ��� ǰ�� ������ */

	List<Auction> getAuctionList() throws DataAccessException; /* ���ǰ���� ��� */

	List<Auction> getAuctionListByHeader(String userId) throws DataAccessException; /* ����ڰ� ��������ϴ� ǰ�� ��� */

	List<Auction> getMyAuction(String userId) throws DataAccessException; /* ����ڰ� ��û�� ��� ��� */
	List<Account> getApplyerOfAuction(String aucId); /*�ش� ���������� ��û�� ��� ��ȯ*/

	void insertAuction(Auction auc, PointHistory ph) throws DataAccessException;

	void updateAuction(Auction auc) throws DataAccessException;

	void deleteAuction(String aucId) throws DataAccessException;

	void applyAuction(Auction auc)throws DataAccessException;

	void cancelApplyAuction(String aucId, String userId) throws DataAccessException;
}
